//Brute force approach
//TC:O(N^2)
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int sum =0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                maxSum=Math.max(maxSum,sum);
            }
        }
        return maxSum;
    }
}

//Kadane's Algo
//TC:O(N)
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = nums[0];
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            maxSum=Math.max(maxSum,sum);
            if(sum<0) sum = 0;
        }
        return maxSum;
    }
}
