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

//Optimal 1
//TC:O(2N)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n =s.length();
        //corner case
        if(n==0) return 0;
        int maxi = Integer.MIN_VALUE;
        HashSet<Character> hs = new HashSet<>();
        int  l=0, r=0; 
        while(r<n){
            char ch = s.charAt(r);
            if(!hs.contains(ch)){
                hs.add(ch);
                maxi = Math.max(maxi, r-l+1);
                r++;
            }
            else {
                while(hs.contains(ch)){
                    char charToRemove = s.charAt(l);
                    hs.remove(charToRemove);
                    l++;
                }
                hs.add(ch);
                maxi = Math.max(maxi, r-l+1);
                r++; 
            }
        }
        return maxi;
    }
}

//TC:O(N)
//SC:O(N)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n =s.length();
        //corner case
        if(n==0) return 0;
        int maxi = Integer.MIN_VALUE;
        HashMap<Character,Integer> hm = new HashMap<>();
        int  l=0, r=0; 
        while(r<n){
            char ch = s.charAt(r);
            if(hm.containsKey(ch))
                l = Math.max(hm.get(ch)+1, l);
            hm.put(ch,r);
            maxi = Math.max(maxi, r-l+1);
            r++; 
        }
        return maxi;
    }
}
