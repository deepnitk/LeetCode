class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = 0;
        int rightMax = 0;
        int leftPtr = 0;
        int rightPtr = n-1;
        int trappedWater = 0;
        while(leftPtr < rightPtr) {
            if(height[leftPtr] <= height[rightPtr]){
                if(height[leftPtr] >= leftMax){
                    leftMax = height[leftPtr];
                }
                else {
                    trappedWater += leftMax - height[leftPtr];
                }
                leftPtr++;
            }
            else {
                if(height[rightPtr] >= rightMax){
                    rightMax = height[rightPtr];
                }
                else {
                    trappedWater += rightMax - height[rightPtr];
                }
                rightPtr--;
            }
        }
        
        return trappedWater;
    }
}
