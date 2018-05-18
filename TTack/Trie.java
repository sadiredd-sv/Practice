class TrieNode {
    TrieNode arr[];
    boolean isEnd;

    public TrieNode() {
        this.arr = new TrieNode[26];
        this.isEnd = false;
    }
}

class Trie {

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode p = root;

        for(int i=0; i<word.length(); i++) {
            int index = word.charAt(i)-'a';
            if(p.arr[index]==null) {
                TrieNode temp = new TrieNode();
                p.arr[index] = temp;
                p = temp;
            }else
                p = p.arr[index];
        }
        p.isEnd = true;
    }

    public boolean search(String word) {

        TrieNode p = root;

        for( char c : word.toCharArray() ) {
            if(p.arr[c-'a']==null)
                return false;
            else
                p=p.arr[c-'a'];
        }

        return p.isEnd==true ? true : false;
    }

    public boolean startsWith(String prefix) {

        TrieNode p = root;

        for( char c : prefix.toCharArray() ) {
            if(p.arr[c-'a']==null)
                return false;
            else
                p=p.arr[c-'a'];
        }

        return true;

    }

    /* Handle the . case */
    public boolean dfsSearch(String word) {
        return dfsSearchHelper(root,word,0);
    }

    public boolean dfsSearchHelper(TrieNode p, String word, int start) {

        if(  p.isEnd && start == word.length())
            return true;

        char c = word.charAt(start);
        if(c=='.') {

            for(int i=0; i<26; i++) {
                if(p.arr[i]!=null)
                    return dfsSearchHelper(p.arr[i], word, start+1);
            }

        }else {
            if( p.arr[c-'a']!=null )
                return dfsSearchHelper(p.arr[c-'a'], word, start+1);
            else
                return false;
        }

        return false;
    }

    public static void main(String args[]) {
        Trie trie = new Trie();
        trie.insert("ambiguous");

        System.out.println(trie.search("ambiguous"));
        System.out.println(trie.startsWith("am"));

        System.out.println(trie.dfsSearch("ambiguous"));
    }
}