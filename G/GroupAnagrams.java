import java.util.*;

class GroupAnagrams {

    public static void group(String words[]) {
        List<List<String>> ouput = new ArrayList<List<String>>();
        Map<String,List<String>> map = new HashMap<String,List<String>>();

        for(String word : words) {
            char temp[] = new char[26];
            for(int i=0; i<word.length(); i++) {
                temp[word.charAt(i)-'a']++;
            }
            String x = new String(temp);
            System.out.println(x);
        }
    }

    public static void main(String args[]) {
//        String words[] = { "eat", "pots", "onset", "stone", "rail", "risen", "caret", "resin", "react", "siren",
//                "sitar", "stair", "liar", "stop", "trace", "notes", "tea", "lair" };
        String words[] = { "eat"};
        group(words);
    }
}