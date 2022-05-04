//Brute force solution
//TC:O(N2)
class Solution {
    public int maxArea(int[] height) {
        int maxi = Integer.MIN_VALUE;
        int maxHeight = 0;
        int n = height.length;
        
        //Base case
        if (n<2) {
            return 0;
        }
        
        for(int i=0;i<n-1;i++){
            for(int j = i+1; j<n;j++){
                int minHeight = Math.min(height[i], height[j]);
                int length = j - i;
                maxi = Math.max(maxi, minHeight*length);
            }
        }
        return maxi;
    }
}

//Two pointer approach
//TC:O(N)
class Solution {
    public int maxArea(int[] height) {
        int maxi = 0;
        int ptr1 = 0;
        int ptr2 = height.length-1;
        while (ptr1 < ptr2) {
            if (height[ptr1] < height[ptr2]){
                maxi = Math.max(maxi, height[ptr1] * (ptr2-ptr1));
                ptr1++;
            }
            else {
                maxi = Math.max(maxi, height[ptr2] * (ptr2-ptr1));
                ptr2--;
                
            }
        }
        return maxi;
    }
}
