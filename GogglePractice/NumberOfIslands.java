class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int noOfIsland = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    // dfs(grid, row, col, rows, cols);
                    callBfs(grid, row, col, rows,cols);
                    noOfIsland++;
                }
            }
        }
        return noOfIsland;
    }
    
    private void dfs(char[][] grid, int row, int col, int rows, int cols) {
        if(grid[row] [col] == '0' || grid[row][col] == '2') {
            return;
        }
        
        grid[row][col] = '2';
        
        if (row - 1 >= 0) {
            dfs(grid, row - 1, col, rows, cols);
        }
        if (row + 1 < rows) {
            dfs(grid, row + 1, col, rows, cols);
        }
        if (col - 1 >= 0) {
            dfs(grid, row, col - 1, rows, cols);
        }
        if (col + 1 < cols) {
            dfs(grid, row, col + 1, rows, cols);
        }
    }
    
    private void callBfs(char[][] grid, int row, int col, int rows, int cols) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair <Integer,Integer> (row,col));
        grid[row][col] = '#';
        int[][] directions = { {-1, 0}, {1, 0}, {0,-1}, {-1,0} };
        while (!queue.isEmpty()) {
            Pair<Integer,Integer> temp = queue.poll();
            int x = temp.getKey();
            int y = temp.getValue();
            if(x<m-1 && grid[x+1][y] == '1' )
            {
                queue.add(new Pair <Integer,Integer>(x+1,y));
                grid[x+1][y] = '#';
            }
            if(y<n-1 && grid[x][y+1] == '1' )
            {
                queue.add(new Pair <Integer,Integer>(x,y+1));
                grid[x][y+1] = '#';
            }
            if(x>0 && grid[x-1][y] == '1' )
            {
                queue.add(new Pair <Integer,Integer>(x-1,y));
                grid[x-1][y] = '#';
            }
            if(y>0 && grid[x][y-1] == '1' )
            {
                queue.add(new Pair <Integer,Integer>(x,y-1));
                grid[x][y-1] = '#';
            }
}
    }
}
