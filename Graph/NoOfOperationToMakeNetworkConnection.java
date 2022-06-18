class Solution {
    public int makeConnected(int n, int[][] connections) {
        int count = 0;
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        boolean[] visited = new boolean[n];
        int noOfEdges = 0;
        for(int i = 0;i < connections.length; i++) {
            if( adjList.containsKey( connections[i][0] ) ) {
                List<Integer> temp = adjList.get( connections[i][0] );
                temp.add( connections[i][1] );
                adjList.put(connections[i][0], temp);
            }
            else {
                List<Integer> newList = new ArrayList<>();
                newList.add( connections[i][1] );
                adjList.put(connections[i][0], newList);
            }
            if( adjList.containsKey( connections[i][1] ) ) {
                List<Integer> temp = adjList.get( connections[i][1] );
                temp.add( connections[i][0] );
                adjList.put(connections[i][1], temp);
            }
            else {
                List<Integer> newList = new ArrayList<>();
                newList.add( connections[i][0] );
                adjList.put(connections[i][1], newList);
            }
            noOfEdges++;
        }
        
        if (noOfEdges < n -1) {
            return -1;
        }
        
        for(int i = 0; i< n; i++){
            if ( !visited[i] ) {
                count++;
                dfs(i, visited, adjList);
            }
        }
        
        return count - 1;
    }
    
    private void dfs(int i, boolean[] visited, HashMap<Integer, List<Integer>> adjList) {
        visited[i] = true;
        if(adjList.containsKey(i)) {
            for(int next: adjList.get(i)) {
                if ( !visited[next] ) {
                    dfs(next, visited, adjList);
                }
            }            
        }
    }
}
