//TC:O(N2)
class Solution {
    List<List<Integer>> res  = new ArrayList<List<Integer>>();
    Set<List> tripletSet= new HashSet<>();
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if(n<3){
            return res;
        }
        for(int i =0;i<nums.length-2;i++){
            helper(nums, i);
        }
        
        for(List triplet: tripletSet) {
            res.add(triplet);
        }
        return res;
    }
    
    public void helper(int[] nums, int i) {
        int ptr1 = i+1;
        int ptr2 = nums.length - 1;
        while(ptr1<ptr2) {
            int sum = nums[i] + nums[ptr1] + nums[ptr2];
            if(sum == 0){
                List<Integer> triplet = new ArrayList<Integer>();
                triplet.add(nums[i]);
                triplet.add(nums[ptr1]);
                triplet.add(nums[ptr2]);
                tripletSet.add(triplet);
                ptr1++;
                ptr2--;
            }
            else if (sum<0) {
                ptr1++;
            }
            else {
                ptr2--;
            }
        }
    }
}
