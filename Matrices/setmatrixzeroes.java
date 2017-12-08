class setmatrixzeroes {

	public static void setZeroes(int mat[][]){
		int col[]=new int[mat[0].length];
		int row[] =new int[mat.length];

		boolean row = false;
		boolean col = false;
		//use the first row and first column - save 
		for (int i=0; i< mat.length;i++) {
			if(mat[i][0]==1)
				col=true;
		}

		for (int j=0; j< mat[0].length;j++) {
			if(mat[0][j]==1)
				row=true;
		}

		//set the first row and first column to zero
		for (int i=0; i< mat.length;i++) {
			mat[i][0]=0;
		}

		for (int j=0; j< mat[0].length;j++) {
			mat[0][j]=0;
		}

		//actual logic using first row and first col:
		for (int i=0; i< mat.length;i++) {
			for (int j=0;j<mat[0].length;j++) {
				if(mat[i][j]==1){
					row[i]=1;
					col[j]=1;
				}
			}
		}

		for (int i=0; i< mat.length;i++) {
			for (int j=0;j<mat[0].length;j++) {
				if(row[i]==1 || col[j] ==1 ){
					mat[i][j]=1;
				}
			}
		}

	}

	public static void main(String args[]){
		int mat[][] = { {1, 0, 0, 1},{0, 0, 1, 0},{0, 0, 0, 0} };

		setZeroes(mat);

		for (int i=0; i< mat.length;i++) {
			for (int j=0;j<mat[0].length;j++) {
				System.out.print(mat[i][j]+ " ");
			}
			System.out.println();
		}

	}
}