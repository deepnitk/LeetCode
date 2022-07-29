//Brute -- using XOR concept x ^ x = ?

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int ans = 0;
        for (int el : nums) {
            ans = ans ^ el;
        }
        
        return ans;
    }
}
