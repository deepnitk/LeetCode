//Optimal
//tc:o(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxi = 0;
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        while (r < s.length()) {
            if ( hm.containsKey(s.charAt(r)))
                l = Math.max(hm.get(s.charAt(r)) + 1, l);
            hm.put(s.charAt(r), r);
            maxi = Math.max(maxi, r - l + 1);
            r++;
        }
        return maxi;
    }
}
