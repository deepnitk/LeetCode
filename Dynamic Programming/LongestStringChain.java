//Build on top of LIS solution

class Solution {
    
    class comp implements Comparator<String> {
      public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
      }
    }  
    
    public int longestStrChain(String[] words) {
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        
        Arrays.sort(words, new comp());
        
        for(int idx = 0; idx<n;idx++) {
            for(int prev_idx = 0; prev_idx<idx; prev_idx++){
                if (compare(words[prev_idx], words[idx]) && 1+dp[prev_idx] > dp[idx]) {
                   dp[idx] = Math.max(1+dp[prev_idx], dp[idx]);
                }
            }
        }
        int maxLen = 0;
        for(int el:dp){
            maxLen = Math.max(maxLen, el);
        }
        return maxLen;        
    }
    
    public boolean compare(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (Math.abs(l2 - l1) != 1) {
            return false;
        }
        int i = 0;
        int j = 0;
        int misMatchCount = 0;
        while(i<l1 && j<l2) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(j);
            if(c1 == c2) {
                i++;
                j++;
            }
            else {
                j++;
                misMatchCount++;
                if(misMatchCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }
    
                
}
