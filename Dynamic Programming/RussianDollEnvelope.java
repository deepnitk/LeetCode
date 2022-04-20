//TC:O(NLOGN)
//SC:O(N)
class Solution {
    class Pair implements Comparable<Pair> {
        int weight;
        int height;
        
        public Pair(int weight, int height){
            this.weight = weight;
            this.height = height;
        }
        
        @Override
        public int compareTo(Pair o){
            return this.height - o.height;
        }
    }
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        ArrayList<Pair> list = new ArrayList<Pair>();
        for(int i=0;i<n;i++)
            list.add(new Pair(envelopes[i][0],envelopes[i][1]));
        
        Collections.sort(list);
        
        int[] dp = new int[n];
        int ans = 1;
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(list.get(j).weight<list.get(i).weight && list.get(j).height<list.get(i).height)
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                    // update answer
                    ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}
