//Recursive solution

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxi = Integer.MAX_VALUE;
        for(int j=0; j< n;j++){
            int ans = minFallingPathSumUtils(m-1, j, matrix);
            maxi = Math.min(maxi, ans);
        }
        return maxi;
    }
    
    private int minFallingPathSumUtils(int i, int j, int[][] matrix){
        //Base case
        // out of bound
        if(j<0 || j >= matrix.length) return (int)Math.pow(10,9);
        // Destination
        if(i == 0) return matrix[0][j];
        
        int s = matrix[i][j] + minFallingPathSumUtils(i-1, j, matrix);
        int ld = matrix[i][j] + minFallingPathSumUtils(i-1, j-1, matrix);
        int rd = matrix[i][j] + minFallingPathSumUtils(i-1, j+1, matrix);
        
        return Math.min(s, Math.min(ld, rd));
        
    }
    
}
