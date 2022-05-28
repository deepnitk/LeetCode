//TC: O(M*N)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int top =0;
        int bottom = matrix.length;
        int right = matrix[0].length;
	
	while (left < right && top < bottom) {
		for (int i = left ; i<right; i++) {
			res.add(matrix[top][i]);
		}
		top++;
		for (int i = top ; i<bottom; i++) {
			res.add(matrix[i][right -1]);
		}
		right--;
		if (!(left < right && top < bottom)) {
			break;
		}
		for( int i = right-1; i>left-1; i--) {
			res.add(matrix[bottom - 1][i]);
		}
		bottom--;
		for(int i = bottom-1; i>top-1; i--) {
			res.add(matrix[i][left]);
		}
		left++;
	}
	
	return res;
    }
}
