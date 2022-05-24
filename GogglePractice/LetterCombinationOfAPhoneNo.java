class Solution {
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        List<String> res = new ArrayList<>();
        HashMap<Character, String> hm = new HashMap<>();
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");
        if (n < 1) {
            return res;
        }
        generateCombinations(digits, 0, res, hm, new StringBuilder());
        return res;
    }
    
    public void generateCombinations(String digits, int idx, List<String> res, HashMap<Character,String> hm, StringBuilder s) {
        if(idx == digits.length()) {
            res.add(s.toString());
            return;
        }

        String letters = hm.get(digits.charAt(idx));
        for(int i = 0; i < letters.length(); i++) {
            s.append(letters.charAt(i));
            generateCombinations(digits, idx + 1, res,hm, s);
            s.deleteCharAt(s.length()-1);
        } 
    }
}
