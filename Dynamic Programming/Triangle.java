//Recursive Solution

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(0).size();
        return minimumTotalUtil(0,0,triangle, m);
    }
    
    private int minimumTotalUtil(int i,int j, List<List<Integer>> triangle, int m) {
      //Base case
        if(i==m-1) return triangle.get(m-1).get(j);
        int down = triangle.get(i).get(j) + minimumTotalUtil(i+1, j, triangle, m);
        int diag = triangle.get(i).get(j) + minimumTotalUtil(i+1, j+1, triangle, m);
        return Math.min(down, diag);
    }
    
}
