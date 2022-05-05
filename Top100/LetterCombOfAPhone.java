class Solution {
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> hm = new HashMap<>();
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wxyz");
        
        int n = digits.length();
        if (n < 1) {
            return res;
        }
        StringBuilder s = new StringBuilder();
        helper(digits, 0 , n, s, hm);
        return res;
    }
    
    public void helper(String digits, int i, int n, StringBuilder s, HashMap<Character, String> hm) {
        if (i==n) {
            res.add(s.toString());
            return;
        }
        
        String letters = hm.get(digits.charAt(i));
        for(int k=0;k<letters.length();k++){
            s.append(letters.charAt(k));
            helper(digits,i+1,n,s,hm);
            s.deleteCharAt(s.length()-1);
        }
    }
}
