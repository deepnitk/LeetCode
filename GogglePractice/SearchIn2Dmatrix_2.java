//Awesome case 
//represent 2d array in 1d fashion like res = (0 to m*n - 1)
// r will be res/m and c will be res%n
//tc : log(m*n)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int lo  = 0;
        int hi = (m * n) - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            int r = mid / m;
            int c = mid % m;
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
