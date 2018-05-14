import java.util.*;

/* An instance of this class is returned as the final output containing best path with leastConversionCost */
class BestPathOutput {
    String bestPath;
    int leastConversionCost;
    BestPathOutput(String bestPath, int leastConversionCost) {
        this.bestPath = bestPath;
        this.leastConversionCost = leastConversionCost;
    }
}


class Exchange {

    static Map<String, List<Integer>> input = new HashMap<String, List<Integer>>();

    static Map<String, List<String> > map = new HashMap<>();

    static Map<String, Boolean> isvisited = new HashMap<>();

    static Map<Integer, String> conversionCostToPathMap = new HashMap<>();


    /* Returns the best path */
    public static BestPathOutput exchange(String base, String quote) {

        initializeVistedAsFalse(base);
        List<Integer> output = new ArrayList<>();
        System.out.println("All paths from "+ base+" to "+quote+":");
        exchangeHelper(base,quote,base,output);

        int min = Integer.MAX_VALUE;
        for(int i : conversionCostToPathMap.keySet()) {
            if(i < min)
                min =i;
        }

        return new BestPathOutput(conversionCostToPathMap.get(min),min);

    }

    /* Print all paths */
    public static void exchangeHelper(String base, String quote, String path, List<Integer> output) {

        if(base.equals(quote)) {

            System.out.println(path);
            int total =0;
            for(int i : output) {
                System.out.print(i+" ");
                total+=i;
            }
            System.out.println("\n");
            conversionCostToPathMap.put(total,path);

            isvisited.put(quote,false); // mark the destination quote as unvisited to let the other paths lead to this destination quote
            return;
        }

        for( String currency : map.get(base) ) {

            if(isvisited.get(currency)!=null && !isvisited.get(currency)) {

                isvisited.put(currency,true);
                path=path +"-"+currency;

                // base to currency conversion: If "currency-base" is present in the map, then pick the "ask" value
                if(input.get(currency+"-"+base)!=null)
                    output.add(input.get(currency+"-"+base).get(0));
                else
                    // base to currency conversion: If "currency-base" not present in the map but "base-currency" is present, then pick the "bid" value
                    output.add(input.get(base+"-"+currency).get(1));

                exchangeHelper(currency, quote, path, output);
                output.remove(output.size()-1); // backtrack - This was what I tried to explain the interview
                path= path.substring(0,path.lastIndexOf("-")); // backtrack - This was what I tried to explain the interview
            }
        }

    }


    /*

      Final "input" would look like:
        Key = BTC-USD ; Values=  { 1000, 990 },
        Key = BTC-EUR : Values = { 1200, 1150 },
        Key = ETH-USD : Values = { 200, 180 },
        Key = ETH-EUR : Values = { 220, 210 }
    */
    public static void buildTickers() {

        List<Integer> btcUsd = new ArrayList<Integer>(Arrays.asList(1000,990));
        input.put("BTC-USD",btcUsd);

        List<Integer> btcEur = new ArrayList<Integer>(Arrays.asList(1200,1150));
        input.put("BTC-EUR",btcEur);

        List<Integer> ethUsd = new ArrayList<Integer>(Arrays.asList(200,180));
        input.put("ETH-USD",ethUsd);

        List<Integer> ethEur = new ArrayList<Integer>(Arrays.asList(220,210));
        input.put("ETH-EUR",ethEur);
    }


    /*
       Final "map" would look like:
        USD: [BTC, ETH]
        ETH: [USD, EUR]
        BTC: [USD, EUR]
        EUR: [BTC, ETH]
    */
    public static void buildAdjancencyListForEveryCurrency() {

        for(String s : input.keySet()){

            String []arr = s.split("-");

            if(map.containsKey(arr[0])) {
                List<String> list = map.get(arr[0]);
                list.add(arr[1]);
                map.put(arr[0],list);
            } else {
                List<String> list = new ArrayList<>(Arrays.asList(arr[1]));
                map.put(arr[0],list);
            }
            if(map.containsKey(arr[1])) {
                List<String> list = map.get(arr[1]);
                list.add(arr[0]);
                map.put(arr[1],list);
            }
            else {
                List<String>  list = new ArrayList<>(Arrays.asList(arr[0]));
                map.put(arr[1], list);
            }

        }
    }

    public static void initializeVistedAsFalse(String base) {

        isvisited.put("USD",false);
        isvisited.put("EUR",false);
        isvisited.put("ETH",false);
        isvisited.put("BTC",false);

        isvisited.put(base,true); // mark the start currency as visited
    }

    public static void main(String args[]) {

        /* build the given input into in-memory DS */
        buildTickers();

        /* build adjacency graph for each currency */
        buildAdjancencyListForEveryCurrency();


        /* Main method calls while testing */
        String base = null, quote=null;
        BestPathOutput bestPathOutput=null;


        /* Test 1: USD to EUR */
        System.out.println("---- Test 1 ----");
        base = "USD";
        quote= "EUR";
        bestPathOutput = exchange(base,quote);
        System.out.println("Best exchange rate path : " + bestPathOutput.bestPath);
        System.out.println("Best exchange rate price : " + bestPathOutput.leastConversionCost);
        System.out.println("------------------------------------------------\n");


        /* Test 2: EUR to USD */
        System.out.println("---- Test 2 ----");
        base = "EUR";
        quote= "USD";
        bestPathOutput = exchange(base,quote);
        System.out.println("Best exchange rate path : " + bestPathOutput.bestPath);
        System.out.println("Best exchange rate price : " + bestPathOutput.leastConversionCost);
        System.out.println("------------------------------------------------\n");


        /* Test 3: BTC to ETH */
        System.out.println("---- Test 3 ----");
        base = "BTC";
        quote= "ETH";
        bestPathOutput = exchange(base,quote);
        System.out.println("Best exchange rate path : " + bestPathOutput.bestPath);
        System.out.println("Best exchange rate price : " + bestPathOutput.leastConversionCost);
        System.out.println("------------------------------------------------\n");


        /* Test 4: ETH to BTC */
        System.out.println("---- Test 4 ----");
        base = "ETH";
        quote= "BTC";
        bestPathOutput = exchange(base,quote);
        System.out.println("Best exchange rate path : " + bestPathOutput.bestPath);
        System.out.println("Best exchange rate price : " + bestPathOutput.leastConversionCost);

    }


}