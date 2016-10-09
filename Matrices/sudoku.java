/*
check the sum on each row
check the sum on each column
check for sum on each box
check for duplicate numbers on each row
check for duplicate numbers on each column
check for duplicate numbers on each box
*/

class sudoku {

	public static boolean checkSudoku(int arr[][]){

		if(arr == null || arr.length !=9 || arr[0].length !=9)
			return false;
		int sum;
		//check for columns
		for (int j=0;j<arr[0].length;j++){
			boolean b[] = new boolean[9];
			sum=0;
			for (int i=0;i<arr.length;i++) {
				sum +=arr[i][j];
				if(arr[i][j]!=0) {
					if(b[arr[i][j]-1])
						return false;
					else
						b[arr[i][j]-1] = true;
				}
			}
			if(sum!=45)
				return false;
		}
		
		//check for rows
		for(int i=0;i<arr.length;i++){
			boolean b[] = new boolean[9];
			sum=0;
			for(int j=0;j<arr[0].length;j++){
				sum +=arr[i][j];
				if(arr[i][j] !=0 ){
					if(b[arr[i][j]-1])
						return false;
					else
						b[arr[i][j]-1] = true;
				}
			}
			if(sum!=45)
				return false;
		}

		//check for 3x3 matrices
		for(int block=0; block <9; block++){

			boolean b[] = new boolean[9];
			sum=0;
			for (int i=block/3*3;i< block/3*3 + 3; i++){
				for (int j=block%3*3;j< block%3*3 + 3;j++){
					sum +=arr[i][j];
					if(arr[i][j]!=0) {
						if(b[arr[i][j]-1])
							return false;
						else
							b[arr[i][j]-1] = true;
				}
			}
		}
		if(sum!=45)
			return false;
	}
		
		return true;
	}

	public static void main(String args[]) {

		int arr[][] = new int[9][9];
		System.out.println(arr[0][0]+" - val \n");

		arr[0][0]=3;
		arr[0][1]=9;
		arr[0][2]=4;
		arr[0][3]=8;
		arr[0][4]=5;
		arr[0][5]=2;
		arr[0][6]=6;
		arr[0][7]=7;
		arr[0][8]=1;

		arr[1][0]=2;
		arr[1][1]=6;
		arr[1][2]=8;
		arr[1][3]=3;
		arr[1][4]=7;
		arr[1][5]=1;
		arr[1][6]=4;
		arr[1][7]=5;
		arr[1][8]=9;

		arr[2][0]=5;
		arr[2][1]=7;
		arr[2][2]=1;
		arr[2][3]=6;
		arr[2][4]=9;
		arr[2][5]=4;
		arr[2][6]=8;
		arr[2][7]=2;
		arr[2][8]=3;

		arr[3][0]=1;
		arr[3][1]=4;
		arr[3][2]=5;
		arr[3][3]=7;
		arr[3][4]=8;
		arr[3][5]=3;
		arr[3][6]=9;
		arr[3][7]=6;
		arr[3][8]=2;

		arr[4][0]=6;
		arr[4][1]=8;
		arr[4][2]=2;
		arr[4][3]=9;
		arr[4][4]=4;
		arr[4][5]=5;
		arr[4][6]=3;
		arr[4][7]=1;
		arr[4][8]=7;

		arr[5][0]=9;
		arr[5][1]=3;
		arr[5][2]=7;
		arr[5][3]=1;
		arr[5][4]=2;
		arr[5][5]=6;
		arr[5][6]=5;
		arr[5][7]=8;
		arr[5][8]=4;

		arr[6][0]=4;
		arr[6][1]=1;
		arr[6][2]=3;
		arr[6][3]=5;
		arr[6][4]=6;
		arr[6][5]=7;
		arr[6][6]=2;
		arr[6][7]=9;
		arr[6][8]=8;

		arr[7][0]=7;
		arr[7][1]=5;
		arr[7][2]=9;
		arr[7][3]=2;
		arr[7][4]=3;
		arr[7][5]=8;
		arr[7][6]=1;
		arr[7][7]=4;
		arr[7][8]=6;

		arr[8][0]=8;
		arr[8][1]=2;
		arr[8][2]=6;
		arr[8][3]=4;
		arr[8][4]=1;
		arr[8][5]=9;
		arr[8][6]=7;
		arr[8][7]=3;
		arr[8][8]=5;

		for (int i=0; i< 9;i++) {
			for (int j=0;j<9;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

		System.out.println("Is Column sudoku : "+checkSudoku(arr));
	}	
}