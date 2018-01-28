/*

https://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/

Input:  arr[] = {1, 6, 11, 5} 
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12 
Subset2 = {11}, sum of Subset2 = 11   


Algorithm:

f(arr, arr.length-1, 0, sumofallelementsinarray)


int f(arr, n, currSum, totalSum) {
	
	if(n==0){
		int sum2 = totalSum-currsum;
		return Math.abs(sum2-currSum);
	}

	return Math.min( f(arr,n-1,currsum+arr[n],totalsum) , f(arr,n-1,currsum,totalsum) )
}


*/

class PartitionSetWithMinimalDifference {

}