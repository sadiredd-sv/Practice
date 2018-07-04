import java.util.*;

class Boggle {

    int x[] = {1,0,-1,-1,-1,0,1,1};
    int y[] = {-1,-1,-1,0,1,1,1,0};

    char boggle[][];
    boolean visited[][];
    Set<String> dict;

     public Boggle() {
        boggle = new char[][]{  {'G','I','Z'},
                                {'U','E','K'},
                                {'Q','S','E'}
                            };
        visited = new boolean[boggle.length][boggle[0].length];
        dict = new HashSet<String>(Arrays.asList("GEEKS", "FOR", "QUIZ", "GO"));
    }

    public boolean isSafe(int x, int y) {
        if(x>=0 && x<boggle.length && y>=0 && y<boggle[0].length && !visited[x][y])
            return true;
        return false;
    }

    public void listAllWords(int i, int j, String str) {

        visited[i][j] = true;
        str+=String.valueOf(boggle[i][j]);

        if(dict.contains(str)) {
            System.out.println(str);
            return;
        }

        for(int k=0; k<8; k++) {
            if(isSafe( i+x[k],j+y[k])) {
                listAllWords(i+x[k],j+y[k],str);
            }
        }

        str = str.substring(0,str.length()-1);
        visited[i][j]=false;

    }

    public void clearVisited() {
        for(int i=0; i< visited.length; i++)
            for(int j=0; j< visited[0].length; j++)
                visited[i][j]=false;
    }

    public static void main(String args[]) {

        Boggle b = new Boggle();
        b.clearVisited();

        for(int i=0; i< b.boggle.length; i++) {
            for(int j=0; j< b.boggle[0].length; j++) {
                b.listAllWords(i, j,"");
                b.clearVisited();
            }
        }
    }
}