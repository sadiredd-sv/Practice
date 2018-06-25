import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/*
. Date d=new Date();
SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
String _format=sdf.format(d);
System.out.println("the date is:"+_format);
*/

class Event {
    Date startDate, endDate;
    String customer;
    int id;

    public Event(Date startDate, Date endDate, String customer, int id) {
        this.startDate=startDate;
        this.endDate=endDate;
        this.customer=customer;
        this.id = id;
    }

}

class Calendar {
    int counter;
    Map<String, List<Event>> map;

    Map<Integer, String> indexMap;

    public Calendar() {
        map = new HashMap<>();
        counter=0;
    }

    public void addEvent(Date startDate, Date endDate, String name) {

        counter++;

        Event e1 = new Event(startDate,endDate,name,counter);

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
        String _format=sdf.format(startDate);
        //System.out.println("the date is:"+_format);

        indexMap.put(e1.id, _format);

        List<Event> list=null;
        if(!map.containsKey(_format)) {
            list = new ArrayList<Event>();
        }
        else
            list = map.get(_format);

        list.add(e1);
        map.put(_format, list);

    }

    public void deleteEvent(int id) {

        List<Event> events = map.get(indexMap.get(id));

        for(Event event : events) {
            if(event.id == id) {
                events.remove(event);
                indexMap.remove(id);
            }
        }
    }
}

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Calendar c = new Calendar();
        c.addEvent(new Date(), new Date(), "abc");
    }
}