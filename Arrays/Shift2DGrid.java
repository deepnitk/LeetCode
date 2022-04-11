class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        
        int temp[][] = new int[row][col];
        
        // Solution Approach:
        // Assume if we convert given array into 1D Array then shift element to k positions and after shiting all the elements we will again convert 1D Array to our original dimention array.
        
        // Logic for Finding current elements's index in 1D Array after shifting K times : 
        // For current element We will just find that what will be it's index in 1D Array 
        // After for New postion in 1D Array we will shift it k times means we will add K in current index
        // And if new positon in 1D Array get's increased by it's total size, we will modulo it by 1D Array Size
      
        for(int i = 0;i<row;i++){
            for(int j=0;j<col;j++){
                // (i * col) + j : will Give Index in 1D Array
                // (i * col) + j + k : Adding K means we will shift it k times
                // ((i * col) + j + k ) % (row * col) : modulo it by array size (row * col), if it exceeds the size
                int indexIn1DArray = ((i * col) + j + k ) % (row * col);
              
                int tempRowIndex = indexIn1DArray / col; // Find the particular row
                int tempColIndex = indexIn1DArray % col; // Find the particular column
                temp[tempRowIndex][tempColIndex] = grid[i][j]; // Add Element at that new index in our temporary result array
            }
        }
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for(int i = 0; i < row; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for(int j = 0; j < col; j++) {
                list.add(temp[i][j]);
            }
            result.add(list);
        }
        
        return result;
    }
}
