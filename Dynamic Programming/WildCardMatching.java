//Recursive Solution
//TC:O(2^N) Exponential
//SC:O(Exponential)
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        return isMatchUtil(n-1,m-1,s,p);
    }
    
    private boolean isMatchUtil(int i, int j, String s1, String s2){
        if(i<0 && j<0) return true;
        if(i<0 && j>=0) return false;
        if(j<0 && i>=0){
            for(int k=0;k<=i;k++){
                if(s1.charAt(k) != '*') return false;
            }
            return true;
        }
        
        if(s1.charAt(i)==s2.charAt(j) || s1.charAt(i)=='?') 
            return isMatchUtil(i-1,j-1,s1,s2);
        if(s1.charAt(i)=='*')
            return isMatchUtil(i-1,j,s1,s2) || isMatchUtil(i,j-1,s1,s2);
        return false;
    }
}
