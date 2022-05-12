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
                if (compare(words[idx],words[prev_idx]) && 1+dp[prev_idx] > dp[idx]) {
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
    
    public boolean compare(String curr, String prev) {
        int currLen = curr.length();
        int prevLen = prev.length();
        
        if(currLen != prevLen +1) {
            return false;
        }
        
        int first = 0; 
        int second = 0;
        while(first < currLen){
            if(second < prevLen && curr.charAt(first) == prev.charAt(second)) {
                first++;
                second++;
            }
            else {
                first++;
            }
        }
        
        if(first == currLen && second == prevLen) {
            return true;
        }
        return false;
    }
    
                
}
