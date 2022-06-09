//Naive Solution
//TC: O(n *log(m))
class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		int n = matrix.length;
		int m = matrix[0].length;
		for ( int i = 0; i < n; i++) {
            boolean rowSearch = find(matrix, i, m, target);
			 if ( rowSearch ) {
                 return true;
             }
        }
        return false;
    }
    public boolean find(int[][] matrix, int row, int m, int target) {
        int lo = 0;
        int hi = m - 1;
        while ( lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if ( matrix[row][mid] == target ) {
                return true;
            }
            else if ( matrix[row][mid] < target) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return false;
    }
}
