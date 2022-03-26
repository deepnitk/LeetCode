//Recursive Solution

class Solution {
    public int uniquePaths(int m, int n) {
        return uniquePathUtils(m-1, n-1);
    }
    
    private int uniquePathUtils(int i, int j){
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;
        int top = uniquePathUtils(i-1, j);
        int left = uniquePathUtils(i, j-1);
        return top+left;
    }
}
