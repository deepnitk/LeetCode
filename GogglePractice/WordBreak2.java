class Node {
    Node links[] = new Node[26];
    int wordCount = 0;
    
    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }
    
    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }
    
    Node get(char ch) {
        return links[ch - 'a'];
    }
    
    void increaseEnd() {
        wordCount++;
    }
    
    int getEnd(){
        return wordCount;
    }
};

class Solution {
    private static Node root;
    
    public Solution () {
        root = new Node();
    }
    
    public void wordBreakUtil(String s, List<String> st, int pos, List<String> res) {
        if (pos == s.length()) {
            StringBuilder sb = new StringBuilder();
            for(String word: st){
                sb.append(word);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return;
        }
        
        for (int i = pos;i<s.length(); ++i) {
            if (search(s.substring(pos, i + 1))) {

                st.add(s.substring(pos, i + 1));
                wordBreakUtil(s, st, i+1, res); 
                st.remove(st.size() -1);
            }
        }
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        for(String word: wordDict) {
            insert(word);
        }
        List<String> res = new ArrayList<>();
        //Make Partition and check
        List<String> st = new ArrayList();
        for(int i = 0;i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            if(search(s.substring(0, i+1))) {
                st.add(s.substring(0, i+1));
                wordBreakUtil(s, st, i+1, res);
                st.remove(st.size() - 1);
            }
        }
        return res;
    }
    
    public void insert(String word) {
        Node node = root;
        for(int i = 0;i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            //Move to ref trie
            node = node.get(word.charAt(i));
        }
        node.increaseEnd();
    }
    
    public boolean search(String prefix) {
        Node node = root;
        for(int i = 0;i < prefix.length(); i++) {
            if (!node.containsKey(prefix.charAt(i))) {
                return false;
            }
            //Move to ref trie
            node = node.get(prefix.charAt(i));
        }
        return node.getEnd() > 0;
    }
}
