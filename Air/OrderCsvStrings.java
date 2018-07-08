import java.util.*;

class Csv implements Comparable<Csv> {
    int hostId, listingId;
    double score;
    String city;

    public Csv(int hostId, double score) {
        this.hostId = hostId;
        this.score = score;
    }

    @Override
    public int compareTo(Csv csv) {
        return (int)this.score - (int)csv.score;
    }

    @Override
    public String toString() {
        return "Score - "+score;
    }
}

class CsvWrapper implements Comparable<CsvWrapper> {
    List<Csv> listForHost;
    int index;

    CsvWrapper(List<Csv> listForHost, int index){
        this.listForHost = new ArrayList<Csv>(listForHost);
        this.index= index;
    }

    @Override
    public int compareTo(CsvWrapper csvWrapper) {
        return (int)this.listForHost.get(index).score - (int)csvWrapper.listForHost.get(csvWrapper.index).score;
    }
}

class OrderCsvStrings {

    Map<Integer,List<Csv>> hostToCsv;
    List<Csv> list;

    public OrderCsvStrings() {

        hostToCsv = new HashMap<>();
        list = new ArrayList<Csv>(Arrays.asList(new Csv(1,300.1), new Csv(4,209.1), new Csv(20,208.1),
                new Csv(23,207.1), new Csv(16,206.1), new Csv(1,205.1), new Csv(1,204.6), new Csv(6,204.1),
                new Csv(7,203.1), new Csv(8,202.1), new Csv(2,201.1), new Csv(2,200.1), new Csv(15,109.1),
                new Csv(10,108.1), new Csv(11,107.1), new Csv(12,106.1), new Csv(13,105.1), new Csv(22,104.1),
                new Csv(1,103.1), new Csv(28,102.1), new Csv(18,11.1), new Csv(6,10.1), new Csv(19,9.1),
                new Csv(3,8.1), new Csv(3,7.1), new Csv(27,6.1), new Csv(1,5.1), new Csv(25,4.1), new Csv(5,3.1),
                new Csv(29,2.1), new Csv(30,1.1)
        ));
    }

    public void groupByHost() {
        for( Csv csv : list ) {
            List<Csv> listforHost=null;
            if(!hostToCsv.containsKey(csv.hostId))
                listforHost = new ArrayList();
            else
                listforHost = hostToCsv.get(csv.hostId);

            listforHost.add(csv);
            Collections.sort(listforHost);
            hostToCsv.put(csv.hostId, listforHost);
        }
    }

    public void printMap() {
        for(Map.Entry entry : hostToCsv.entrySet()) {
            System.out.println( "HostId: "+entry.getKey()+", Value: "+entry.getValue() );
        }
    }

    public void priorityQueueBasedPagination() {

        Set<Integer> set = new HashSet<Integer>();
        PriorityQueue<CsvWrapper> pq = new PriorityQueue<CsvWrapper>();
        List<CsvWrapper> temp = new ArrayList<CsvWrapper>();

        for(int hostId : hostToCsv.keySet()) {
            CsvWrapper csvWrapper = new CsvWrapper(hostToCsv.get(hostId),0);
            pq.add(csvWrapper);
        }

        int count=0;

        while(!pq.isEmpty()) {

            if(count%14 ==0) {
                System.out.println("Page no: "+ (count/14+1));
                for(CsvWrapper tempHost : temp)
                    pq.add(tempHost);
                temp.clear();
                set.clear();
                count++;
            }
            else {
                CsvWrapper csvWrapper = pq.poll();
                Csv csvEntry = csvWrapper.listForHost.get(csvWrapper.index);
                if(!set.contains(csvEntry.hostId)) {
                    set.add(csvEntry.hostId);
                    count++;
                    System.out.println("HostId: "+csvEntry.hostId+" "+csvEntry);
                    if(csvWrapper.index < csvWrapper.listForHost.size()-1)
                        pq.add(new CsvWrapper(csvWrapper.listForHost,csvWrapper.index+1));
                }else
                    temp.add(csvWrapper);
            }
        }

        // leftover entries
        if(temp.size()>0) {
            for(CsvWrapper tempHost : temp){
                System.out.println("Leftover HostIds"+tempHost.listForHost.get(tempHost.index).hostId );

                while(tempHost.index < tempHost.listForHost.size()) {
                    Csv tempEntry = tempHost.listForHost.get(tempHost.index);
                    System.out.println("HostId: "+tempEntry.hostId+" "+tempEntry);
                    tempHost.index+=1;
                }
            }
        }


    }

    public static void main(String args[]) {
        OrderCsvStrings orderCsvStrings = new OrderCsvStrings();
        orderCsvStrings.groupByHost();
        orderCsvStrings.printMap();
        orderCsvStrings.priorityQueueBasedPagination();
    }
}