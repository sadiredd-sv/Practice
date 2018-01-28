/*

https://www.geeksforgeeks.org/look-and-say-sequence/

1, 11, 21, 1211, 111221, 312211, 13112221, 1113213211 , .....

Algorithm:

1. f(n) is generated from f(n-1)

2. String f(int n) {
	
	if(n==1)
		return "1";
	if(n==2)
		return "11";

	char[] arr = f(n-1).toCharArrray();
	
	String str="";
	while(i < arr.length) {
		
		int j=i;
		while(j<arr.length-1 && arr[j]==arr[j+1])
			j++;

		str=str+(j-i+1).toString()+arr[i].toString();
		i=j+1;
	}
	return output;
}

*/

class LookAndSay {

	static String lookAndSay(int n) {
		
		if(n==1) return "1";
		if(n==2) return "11";

		char arr[] = lookAndSay(n-1).toCharArray();
		String str="";
		int i=0;
		while(i < arr.length) {
		
			int j=i;
			while(j<arr.length-1 && arr[j]==arr[j+1])
				j++;

			str=str+Integer.toString(j-i+1)+Character.toString(arr[i]);
			i=j+1;
		}
		return str;

	}

	public static void main(String args[]) {
		System.out.println( lookAndSay(8) );
	}

}