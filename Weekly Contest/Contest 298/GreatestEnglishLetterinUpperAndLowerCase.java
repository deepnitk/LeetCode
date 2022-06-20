class Solution {
    public String greatestLetter(String s) {
        HashSet<Character> hs = new HashSet<>();
        StringBuilder res = new StringBuilder();
        for (char i = 'Z';i >=  'A'; i--) {
            if (s.indexOf(i) != -1 && s.indexOf(i + 32) != -1) {
                res.append(i);
                return res.toString();
            }
        }
        return "";
    }
}
