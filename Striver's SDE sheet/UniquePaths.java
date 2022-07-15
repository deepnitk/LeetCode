//Brute force Recursive solution
//TC: exponential 2^m*n
// SC: exponential

class Solution {
    public int uniquePaths(int m, int n) {
        return uniquePathsUtils(0, 0, m, n);
    }
    
    private int uniquePathsUtils(int i , int j, int m, int n) {
        if( i == m - 1 && j == n - 1) {
            return 1;
        }
        if ( i >= m || j >= n){
            return 0;
        }
        
        return uniquePathsUtils(i + 1, j, m, n) + uniquePathsUtils(i, j + 1, m, n);
    }
}
