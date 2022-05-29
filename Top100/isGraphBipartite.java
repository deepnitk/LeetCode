//TC:O(N+E) + O(N) +O(N)
//SC: O(N+E)

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        
		 // If the graph has multiple disconnetced components.
        for(int i = 0; i < n; i++){
            if(color[i] == -1){
                if(!isBfsBipartite(i, graph, color)) return false;
            }  
        }
        
        return true;
    }
    
    public boolean isBfsBipartite(int node, int[][] graph, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 1;
        while(!q.isEmpty()) {
            int nde = q.poll();
            for(int it: graph[nde]) {
                if(color[it] == -1) {
                    color[it] = 1 - color[nde];
                    q.add(it);
                }
                else if( color[it] == color[nde]) {
                    return false;
                }
            }
        }
        return true;
    }
}
