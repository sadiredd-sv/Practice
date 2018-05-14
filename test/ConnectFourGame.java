import java.util.*;

class Checker {
    String color;
    int x,y;
    int column;

    Checker(String color, int column) {
        this.color = color;
        this.column = column;
    }
}

class ConnectFourGame {

    Checker [][]matrix = new Checker[6][7];

    public void fillInMatrix(Checker obj) {

        for(int i=matrix.length-1; i>=0; i--) {
            if(matrix[i][obj.column]==null) {
                obj.x = i;
                obj.y= obj.column;
                matrix[i][obj.column] = obj;

                break;
            }
        }
    }

    public void printBoard() {

        for(int i=0; i < matrix.length; i++ ) {
            for(int j=0; j < matrix[0].length; j++ ) {
                if(matrix[i][j]!=null)
                    System.out.print(matrix[i][j].color+" ");
                else
                    System.out.print("("+i+","+j+")");
            }
            System.out.println();
        }
    }

    public boolean isBoardFull() {
        for(int j=0; j < 7; j++){
            if(matrix[0][j]==null)
                return false;
        }
        return true;
    }


    public boolean isHorizontal(int row, int col, String color) {

        int y=col;
        while(true) {

            while(matrix[row][col].color.equals(color)){
                col++;
            }
            if(!matrix[row][col].color.equals(color)){
                y++;
                col++;
            }

            if(col-y==4)
                return true;
        }

    }

    public static void main(String args[]) {

        ConnectFourGame game = new ConnectFourGame();

        Random rand = new Random();

        boolean red = true;

        while(true) {

            if(game.isBoardFull())
                break;

            int col = rand.nextInt(7);
            while(game.matrix[0][col]!=null) {
                col = rand.nextInt(7);
            }

            if(red) {
                Checker obj = new Checker("red", col );
                game.fillInMatrix(obj);
                red = false;
            } else {
                Checker obj2 = new Checker("black", col);
                game.fillInMatrix(obj2);
                red =true;
            }
            game.printBoard();
            System.out.println();
        }

        //System.out.println("winner"+game.isHorizontal(3,3,"red"));

    }
}