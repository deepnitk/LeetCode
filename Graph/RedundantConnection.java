//TC : O(N^2)
class Solution {
     Set<Integer> seen = new HashSet();
	public int[] findRedundantConnection(int[][] edges) {
		List<List<Integer>> adjList = new ArrayList<>();
        int[] res = new int[2];
        int V = edges.length;
        for(int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for(int[] edge: edges) {
            int src = edge[0];
            int dest = edge[1];
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);

            if(cycleExist(adjList, V, src))
                return edge;
        }
        return null;
    }
    
    private boolean cycleExist(List<List<Integer>>adjList, int V, int src){
        boolean visited[] = new boolean[V+1];
        
        return cycleUtil(adjList, V, visited, src, -1);
    }

    private boolean cycleUtil(List<List<Integer>>adjList, int V, boolean visited[] ,  int node, int par){
        visited[node] = true;
        
        for(int next: adjList.get(node)){
            if ( !visited[next] ) {
                if ( cycleUtil(adjList, V, visited, next, node) ) 
                    return true;
            } else {
                if (next !=par) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
