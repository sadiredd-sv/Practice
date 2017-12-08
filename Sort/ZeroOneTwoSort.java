class ZeroOneTwoSort {

	static void swap(int arr[],int i, int j) {
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

	static void sort(int arr[]) {

		int i=0,j=arr.length-1;

		while(i<=j) {

			if(arr[i]!=0 && arr[j]!=1) {
				swap(arr,i,j);
				i++;j--;
			}
			if(arr[i]==0)
				i++;
			if(arr[j]==1)
				j--;
		}
	}

	public static void main(String args[]) {
		int arr[]={0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
		sort(arr);
		for(int i : arr)
			System.out.println(i);
	}
}