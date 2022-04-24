//Using extra space
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            if(hm.containsKey(nums[i]))
                hm.put(nums[i], hm.get(nums[i])+1);
            else
                hm.put(nums[i], 1);
        }
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()){
            if(entry.getValue()>n/2)
                return entry.getKey();
        }
        return 0;
    }
}

//Moore's Voting Algo
//TC:O(N)
//SC:O(1)
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for(int num:nums){
            if(count == 0) candidate = num;
            else if(candidate == num) count++;
            else count--;
        }
        return candidate;
    }
}
