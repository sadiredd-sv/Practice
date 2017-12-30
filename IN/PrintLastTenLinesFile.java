/*

https://www.geeksforgeeks.org/print-last-10-lines-of-a-given-file/


*/

class PrintLastTenLinesFile {

	public static void printlasttenlines(String str, int n) {

		int len = str.length();
		int end = len;
		int count=0;


		for(int i=len-1; i>=0; i--) {
			if(str.charAt(i)=='\n' && count <n) {
				System.out.println(str.substring(i+1,end));
				end=i;
				count++;
			}
		}
	}

	public static void main(String args[]) {
		String str1 =  "str1\nstr2\nstr3\nstr4\nstr5\nstr6\nstr7\nstr8\nstr9\nstr10\nstr11\nstr12\nstr13\nstr14\nstr15\nstr16\nstr17\nstr18\nstr19\nstr20\nstr21\nstr22\nstr23\nstr24\nstr25";
		printlasttenlines(str1,10);
	}
}