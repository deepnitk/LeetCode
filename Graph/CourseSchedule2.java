class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //based on Kahns algo and topological sorting 
        // first calculate the indegree for each element(the no of dependencies of eaxh element)
        // next put the element with 0 indegree in the queue and process their dependencies and subtract by one in            the array.Also, mark the element in the queue as visited. Add the element to the result array too.
        // Do this till the queue is empty and all the vertexes have been processed.
        // * Graph has to be built to get the connected nodes(neighbours) when we remove the vertex to process it 
        int [] degree = new int [numCourses];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i=0;i<numCourses;i++)
        {
            graph.add(new ArrayList<>());
        }
        
        for(int i=0;i<prerequisites.length;i++)
        {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            // filling up the indegree array 
            degree[prerequisites[i][0]]++;
            
        }
      
        int count=0;// This is to check if there is a cycle 
        Queue<Integer>queue = new ArrayDeque<>();
        boolean [] visited = new boolean[numCourses];
        int [] res = new int[numCourses];// for result or answer
        
        //put the element with 0 indegree in the queue
        for(int i=0;i<numCourses;i++)
        {
            if(degree[i]==0)
            {
                queue.add(i);
            }
        }
        
        // Hit the BFS
        
        while(queue.size()>0)
        {
            int rem =queue.remove();
            visited[rem]=true;
            res[count]=rem;
            ArrayList<Integer> nbrs = graph.get(rem);
            for(int nbr:nbrs)
            {
                degree[nbr]--;// reduce the degree value
                if(degree[nbr] == 0 && visited[nbr]==false)// if zero then add in the queue
                {
                    queue.add(nbr);
                }
            }
            
            count++;
            
        }
        // to check for cycle
        if(count == numCourses)
        {
            return res;
        }
        else 
        {
             return new int[0];
        }
           
        
    }
}
