//Binary search on 2d matrix logic
// TC: O(log(m*n)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int lo = 0;
        int hi = (m * n) - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            int r = mid/n;
            int c = mid%n;
            if (matrix[r][c] == target) {
                return true;
            }
            else if (matrix[r][c] > target) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        return false;
    }
}

// 2nd approach : work with row wise + column wise sorted as well

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] < target) {
                i++;
            }
            else {
                j--;
            }
        }
        return false;
    }
}
