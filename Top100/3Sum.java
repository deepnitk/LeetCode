class Solution {
    List<List<Integer>> res  = new ArrayList<List<Integer>>();
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if(n<3){
            return res;
        }
        for(int i =0;i<nums.length;i++){
            int sum = 0 - nums[i];
            twoSum(i, nums, sum);
        }
        return res;
    }

    public void twoSum(int i, int[] nums, int sum){
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        for(int j=0;j<n;j++){
            if(j!=i){
                int newSum = sum - nums[j];
                if(hm.containsKey(nums[j])){
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[hm.get(nums[j])]);
                    triplet.add(nums[j]);
                    res.add(triplet);
                    
                }
                else {
                    hm.put(newSum, j);
                }
            }
        }
    }
}
