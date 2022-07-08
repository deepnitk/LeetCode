/*
Dijkstra's algoridthm for shortest path using PQ - min_heap
*/

class Solution {
    class Pair implements Comparator<Pair> {
        int v;
        double prob;
        
        public Pair() {}
        
        public Pair(int _v, double _prob) {
            this.v = _v;
            this.prob = _prob;
        }
        
        public int compare(Pair p1, Pair p2) {
            if ( p1.prob == p2.prob) {
                return 0;
            }
            else if ( p1.prob > p2.prob) 
                return -1;
            else
                return 1;
        }
    }
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> graph = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]));
            graph.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]));
        }
        
        double[] probability = new double[n];
        Arrays.fill(probability, 0d);
        probability[start] = 1;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(n, new Pair());
        pq.offer(new Pair(start, 1));
        
        while ( !pq.isEmpty() ) {
            Pair p = pq.poll();
            
            for( Pair nbr: graph.get(p.v)) {
                if ( p.prob * nbr.prob > probability[nbr.v]) {
                    probability[nbr.v] = p.prob * nbr.prob;
                    pq.offer(new Pair(nbr.v, p.prob * nbr.prob));
                }  
            }
        }
        return probability[end];
    }
}
