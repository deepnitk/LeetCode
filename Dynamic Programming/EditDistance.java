//Recursive solution
//TC: Exponential

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        return minDistanceUtils(n-1, m-1, word1, word2);
    }
    
    private int minDistanceUtils(int i, int j, String s1, String s2){
        if(i<0) return j+1;
        if(j<0) return i+1;
        
        if(s1.charAt(i) == s2.charAt(j)) return 0 + minDistanceUtils(i-1, j-1, s1, s2);
        else{
            return Math.min(
                1 + minDistanceUtils(i-1,j, s1,s2), 
                Math.min(
                    1 + minDistanceUtils(i,j-1, s1,s2),
                    1 + minDistanceUtils(i-1,j-1, s1,s2)
                )
            );
        }
    }
}
