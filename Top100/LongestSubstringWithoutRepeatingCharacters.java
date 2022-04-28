//Brute Force
//TC:O(N^3)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n =s.length();
        int maxi = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            for(int j=i;j<n;j++){
                HashSet<Character> hs = new HashSet<>();
                for(int k=i;k<=j;k++){
                    if(!hs.contains(s.charAt(k))){
                        hs.add(s.charAt(k));
                    }
                    else {
                        break;
                    }
                    maxi = Math.max(maxi, hs.size());
                }
            }
        }
        return maxi;
    }
}

//Better approach
//TC:O(N^2)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n =s.length();
        int maxi = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            HashSet<Character> hs = new HashSet<>();
            for(int j=i;j<n;j++){
                if(!hs.contains(s.charAt(j))){
                    hs.add(s.charAt(j));
                }
                else {
                    break;
                }
            }
            maxi = Math.max(maxi, hs.size());
            }
        return maxi;
    }
}
