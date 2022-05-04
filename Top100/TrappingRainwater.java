//Prefix Array solution
//TC: O(N)
//SC:O(1)

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = height[0];
        int rightMax = height[n-1];
        int[] prefixLeftMax = new int[n];
        int[] suffixRightMax = new int[n];
        
        for(int i = 0; i < n; i++) {
            if (height[i] >= leftMax) {
                prefixLeftMax[i] = 0;
                leftMax = height[i];                
            }
            else {
                prefixLeftMax[i] = leftMax - height[i];
            }
        }

        for(int i = n-1; i >= 0; i--) {
            if (height[i] >= rightMax) {
                suffixRightMax[i] = 0;
                rightMax = height[i];                
            }
            else {
                suffixRightMax[i] = rightMax - height[i];
            }
        }
        
        int trappedWater = 0;
        
        for(int i = 0;i<n;i++){
            trappedWater += Math.min(prefixLeftMax[i], suffixRightMax[i]);
        }
        
        return trappedWater;
    }
}
