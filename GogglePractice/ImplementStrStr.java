//TC: O(N + M)
//KMP solution
class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        
        int[] lps = new int[m];
        Arrays.fill(lps, 0);
        
        //Construct LPS
        int prevLPS = 0;
        int i = 1;
        while ( i < m ) {
            if ( needle.charAt(i) == needle.charAt(prevLPS) ) {
                lps[i] = prevLPS + 1;
                prevLPS += 1;
                i += 1;
            }
            else if(prevLPS == 0) {
                lps[i] = 0;
                i += 1;
            }
            else {
                prevLPS = lps[prevLPS - 1];
            }
        }
        
        //KMP algo
        int ptr1 = 0;
        int ptr2 = 0;
        while ( ptr1 < n ) {
            if ( haystack.charAt(ptr1) == needle.charAt(ptr2) ) {
                ptr1 += 1;
                ptr2 += 1;
            }
            else {
                if ( ptr2 == 0 ) {
                    ptr1 += 1;
                }
                else {
                    ptr2 = lps[ptr2 - 1];
                }
            }
            if (ptr2 == m) {
                return  ptr1 - m;
            }
        }
        return -1;
    }
}
