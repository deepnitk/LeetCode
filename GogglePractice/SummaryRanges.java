class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        
        int start = 0;
        int i = 0;
        int n = nums.length;
        
        while (i < n - 1 ) {
            start = i;
            while (i< n - 1 && nums[i] == nums[i+1] -1) {
                i++;
            }
            if (nums[start] != nums[i]){
                StringBuilder s = new StringBuilder();
                s.append(String.valueOf(nums[start]));
                s.append("->");
                s.append(String.valueOf(nums[i]));
                res.add(s.toString());
                i++;
            }
            else {
                res.add(String.valueOf(nums[i]));
                i++;
            }
        }
        if ( i != n) {
            res.add(String.valueOf(nums[i]));
        }
        return res;
    }
}
