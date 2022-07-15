//Brute force
// TC: O(Nlogn) SC: O(N)
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if (hm.containsKey(nums[i]) ) {
                hm.put(nums[i], hm.get(nums[i]) + 1);
            }
            else {
                hm.put(nums[i], 1);
            }
        }
        Iterator it = hm.entrySet().iterator();
        int res = 0;
        int maxi = Integer.MIN_VALUE;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            if ((Integer)entry.getValue() > maxi) {
                maxi = (Integer)entry.getValue();
                res = (Integer)entry.getKey();
            }
        }
        return res;
    }
}

//Optimal Approach
//Moore's Voting algo
// TC: O(N) SC:O(1)
class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int el = 0;
        for(int i = 0; i < nums.length;i++) {
            if(cnt == 0) {
                el = nums[i];
            }
            if (el == nums[i]) {
                cnt += 1;
            }
            else {
                cnt -= 1;
            }
        }
        return el;
    }
}
