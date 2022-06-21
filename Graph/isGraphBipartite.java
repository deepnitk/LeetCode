/* Time Complexity: O(V + E), since in its whole, it is a DFS implementation, V – vertices; E – edges;

Space Complexity: O(V), because, apart from the graph, we maintain a color array. */

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        Arrays.fill(color, -1);
        for(int i = 0;i < n; i++){
            if (color[i] == -1) {
                if (!isBipartiteUtils(graph, i, color)) {
                    return false;
                }
            }
        } 
        return true;     
    }
    
    private boolean isBipartiteUtils(int[][] graph, int node, int[] color) {
        for(Integer next: graph[node]) {
            if(color[next] == -1) {
                color[next] = 1 - color[node];
                if ( !isBipartiteUtils(graph, next, color) ) {
                    return false;
                } 
            }
            else if ( color[next] == color[node] ) {
                    return false;
            }
        }
        return true;     
    }
}
