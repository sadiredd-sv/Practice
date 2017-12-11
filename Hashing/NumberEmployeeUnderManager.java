/*
http://www.geeksforgeeks.org/find-number-of-employees-under-every-manager/

Given a dictionary that contains mapping of employee and his manager as a number of (employee, manager) pairs like below.

{ "A", "C" },
{ "B", "C" },
{ "C", "F" },
{ "D", "E" },
{ "E", "F" },
{ "F", "F" } 

In this example C is manager of A, 
C is also manager of B, F is manager 
of C and so on.


Output should be a Dictionary that contains following.

A - 0  
B - 0
C - 2
D - 0
E - 1
F - 5 


*/
import java.util.*;

class NumberEmployeeUnderManager {

	static HashMap<String,List<String>> reverseMap = new HashMap<String,List<String>>();

	private static void employeesUnderManager(Map<String,String> dataSet) {

		for( Map.Entry<String,String> entry : dataSet.entrySet()) {

			if(reverseMap.get(entry.getValue()) == null){
				List<String> list = new ArrayList<String>();
				list.add(entry.getKey());
				reverseMap.put(entry.getValue(), list );
			}
			else {
				List<String> list = reverseMap.get( entry.getValue() );
				list.add(entry.getKey());
				reverseMap.put( entry.getValue(), list);
			}
		}

		for( Map.Entry<String,List<String>> entry : reverseMap.entrySet() ) {

			int count=0;
			for(String s: entry.getValue() ) {
				if(reverseMap.get(s)!=null && !s.equals(entry.getKey()) )
					count+=reverseMap.get(s).size(); //list.size() gives the number of elements in the ArrayList
			}
			count+=entry.getValue().size();
			if(entry.getValue().contains(entry.getKey()))
				count-=1;
			System.out.println("Key: "+ entry.getKey()+", Value: "+count);
		}
	}

	public static void main(String args[]) {
		Map<String,String> dataSet = new HashMap<String,String>();
		dataSet.put("A", "C");
        dataSet.put("B", "C");
        dataSet.put("C", "F");
        dataSet.put("D", "E");
        dataSet.put("E", "F");
        dataSet.put("F", "F");
        employeesUnderManager(dataSet);
	}
}