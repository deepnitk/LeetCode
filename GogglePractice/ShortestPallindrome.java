//Brute force
//TC: O(N2)
class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        /* 
        s = abcbadef
        rev =fedabcba
        find largest pallindromic segment from begining of s.
        rev the rest and add to begining of s.
        */
        
        StringBuilder rev = new StringBuilder();
        rev.append(s);
        rev.reverse();
        for(int i = 0; i < n; i++) {
            // largest pallindromic segment
            if (s.substring(0, n - i).equals(rev.substring(i)) ) {
                StringBuilder res = new StringBuilder();
                // rev the rest
                res.append(rev.substring(0, i));
                res.append(s);
                return res.toString();
            }
        }
        return "";
    }
}
