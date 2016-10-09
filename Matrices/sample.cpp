void setCol(int** mat, int numRows, int ind) {
    for(int i=0;i<numRows;i++) {
        mat[i][ind] = 1;
    }
    return;
}

void setRow(int** mat, int numCols, int ind) {
    for(int i=0;i<numCols;i++) {
        mat[ind][numCols] = 1;
    }
    return;
}

void modifyMat(int** mat, int n, int m) {


    bool setFirstRow=false, setFirstCol=false;
    
    for(int i=0;i<m;i++) {
        if(mat[0][i]==1) {
            setFirstRow = true; 
        }
        mat[0][i] = 0;
    }
    
    for(int i=0;i<n;i++) {
        if(mat[i][0]==1) {
            setFirstCol = true;
            
        }
        mat[i][0] = 0;
    }
    
    //go through the matrix
    
    for(int i=1;i<n;i++) {
        for(int j=1;j<m;j++) {
            if(mat[i][j]==1) {
                mat[0][j] = 1;
                mat[i][0] = 1;
            }
        }
    }
    
    for(int i=0;i<m;i++) {
        //go through top buffer...
        //if set then setCol(i)...
        
        if(mat[0][i]==1) setCol(mat,n,i);
    
    }
    
    for(inti0;i<n;i++) {
        //go through the first col buffer...
        //if set then setRow (i)...
        if (mat[i][0]==1) setRow(mat,m,i);
    }
    
    if (setFirstRow) setRow(mat,m,0);
    if (setFirstCol) setCol(mat,n,0);
    
    return;
    
}
