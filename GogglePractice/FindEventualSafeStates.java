class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //Prepare incoming Edges list
        List<List<Integer>> incomingEdges = new ArrayList<>();
        for (int i = 0;i< graph.length;i++ ) {
            incomingEdges.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            for (int v : graph[i]) {
                incomingEdges.get(v).add(i);
            }
        }
        
        //Prepare outDegree Array
        int[] outDegree = new int[graph.length];
        for (int i = 0 ;i < graph.length ; i++) {
            for (int v : incomingEdges.get(i)) {
                outDegree[v]++;
            }
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        //Visited array will keep track of the nodes which are entering the queue, only those nodes which are not part of any cycle will enter the queue
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i< outDegree.length; i++) {
            if (outDegree[i] == 0) {
                q.offer(i);
                visited[i] = true;
            }
        }
        
        while (!q.isEmpty()) {
            int curVertex = q.remove();
            for (int nextVertex : incomingEdges.get(curVertex)) {
                outDegree[nextVertex] -= 1;
                //if after disconnecting the edge from terminal/safe node outDegree = 0. we can consider that node as safe node
                if (outDegree[nextVertex] == 0) {
                    q.offer(nextVertex);
                    visited[nextVertex] = true;                    
                }
            }
        }
        
        List<Integer> safeStates = new ArrayList<>();
        for(int i = 0;i < visited.length; i++) {
            if (visited[i] == true) {
                safeStates.add(i);
            }
        }
        return safeStates;
    }
}
