import java.util.*;

class TrieNode {

    TrieNode child[] = new TrieNode[26];
    boolean leaf;

    public TrieNode() {
        leaf=false;
        for(int i=0;i<child.length; i++)
            child[i] = null;
    }
}

class BoggleTrie {

    public static void insert(TrieNode root, String str) {

        TrieNode parent = root;

        for(int i=0; i< str.length(); i++) {
            int index = str.charAt(i)-'A';
                if(parent.child[index]==null)
                    parent.child[index] = new TrieNode();
            parent = parent.child[index];
        }

        parent.leaf = true;
    }

    public static boolean isSafe(int x, int y, boolean visited[][], char boggle[][]) {
        if(x>=0 && x<boggle.length && y>=0 && y<boggle[0].length && !visited[x][y])
            return true;
        return false;
    }

    public static void lookup(TrieNode node, boolean visited[][], int i, int j, char boggle[][], String str) {

        if(node.leaf == true) {
            System.out.println(str);
            return;
        }

        visited[i][j] = true;

        for(int k=0; k<26; k++) {
            if(node.child[k]!=null) {
                char ch = (char)(k+'A');

                int x[] = {1,0,-1,-1,-1,0,1,1};
                int y[] = {-1,-1,-1,0,1,1,1,0};

                for(int m=0; m<8; m++) {
                    if(isSafe(i+x[m],j+y[m],visited, boggle) && boggle[i+x[m]][j+y[m]]==ch)
                        lookup(node.child[k],visited,i+x[m],j+y[m],boggle,str+ch);
                }

            }
        }

        visited[i][j]=false;
    }

    public static void searchWords(char boggle[][], TrieNode root) {
        boolean visited[][] = new boolean[boggle.length][boggle[0].length];

        for(int i=0; i< boggle.length; i++) {
            for(int j=0; j< boggle[0].length; j++) {
                if(root.child[boggle[i][j]-'A']!=null ) {
                    String str = String.valueOf(boggle[i][j]);
                    lookup(root.child[boggle[i][j]-'A'],visited,i,j, boggle,str);
                }
            }
        }
    }

    public static void main(String args[]) {

        List<String> dict = new ArrayList<String>(Arrays.asList("GEE", "FOR", "QUIZ", "GEEKS"));

        TrieNode root = new TrieNode();

        for(String str : dict)
            insert(root,str);

        char boggle[][] = {{'G','I','Z'},
                            {'U','E','K'},
                            {'Q','S','E'}
        };

        searchWords(boggle,root);

    }
}

