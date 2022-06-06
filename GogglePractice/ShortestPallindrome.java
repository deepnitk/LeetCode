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

//Two pointer approach
//TC: O(N2)

class Solution {
    public String shortestPalindrome(String s) {
        // System.out.println("s: "+s);
        int n = s.length();
        int i = 0;
        for(int j = n - 1; j >= 0; j--) {
            if ( s.charAt(i) == s.charAt(j) ) {
                i++;
            }
        }
        if( i == n ) return s;
        
        StringBuilder res = new StringBuilder();
        res.append(s.substring(i, n));
        res.reverse();
        res.append(shortestPalindrome(s.substring(0, i)));
        res.append(s.substring(i));
        return res.toString();

    }
}
