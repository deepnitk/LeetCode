class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        
        int i = 0;
        int n = nums.length;
        
        while (i < n) {
            int start = i;
            int end = i;
            while (end + 1 < n && nums[end + 1] == nums[end] + 1) {
                end++;
            }
            if (end > start){
                StringBuilder s = new StringBuilder();
                s.append(String.valueOf(nums[start]));
                s.append("->");
                s.append(String.valueOf(nums[end]));
                res.add(s.toString());
            }
            else {
                res.add(String.valueOf(nums[start]));
            }
            i = end + 1;
        }

        return res;
    }
}
