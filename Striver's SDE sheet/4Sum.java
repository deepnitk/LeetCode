//Optimal approach
//TC: O(N^3)
//SC: 0(1)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList();        
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i< n; i++) {
            long target3 = (long)target - nums[i];
            for (int j = i + 1; j < n;j++) {
                long rem = target3 - nums[j];                
                int left = j + 1;
                int right = n - 1;
                
                while( left < right) {
                    int twoSum = nums[left] + nums[right];
                    if (twoSum < rem) {
                        left++;
                    }
                    else if (twoSum > rem) {
                        right--;
                    }
                    else {
                        List<Integer> quad = new ArrayList();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[left]);
                        quad.add(nums[right]);
                        res.add(quad);
                        
                        //duplicate 3
                        while (left < right && nums[left] == quad.get(2)) left++;
                        //duplicate 4
                        while (left < right && nums[right] == quad.get(3)) right--;
                    }
                }
                // duplicate 2
                while ( j + 1 < n && nums[j + 1] == nums[j]) j++;
            }
            //duplicate 1
            while ( i + 1 < n && nums[i + 1] == nums[i]) i++;
        }
        return res;
    }
}
