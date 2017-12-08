import java.util.*;

class WordsFromPhoneDigits {

	private Map<Integer, String> phoneDigits = new HashMap<Integer, String>() {{
		put(0,"");
		put(1,"");
		put(2,"abc");
		put(3,"def");
		put(4,"ghi");
		put(5,"jkl");
		put(6,"mno");
		put(7,"pqrs");
		put(8,"tuv");
		put(9,"wxyz");
	}};

	private	char arr[] = new char[4];
	private List<char[]> output = new ArrayList<char[]>();

	private void printWordsFromPhoneDigits(int number[], int currIndex) {

		if(currIndex==number.length) {
			System.out.println(arr);
			//output.add(arr);
			return;
		}

		for(int i=0; i < phoneDigits.get(number[currIndex]).length(); i++) {
			arr[currIndex] = phoneDigits.get(number[currIndex]).charAt(i);
			printWordsFromPhoneDigits(number, currIndex + 1);
		}
			
	}

	public static void main(String args[]) {

		WordsFromPhoneDigits w = new WordsFromPhoneDigits();
		int number[] = {2,3,4};
		w.printWordsFromPhoneDigits(number,0); 
	}                                              	
}
