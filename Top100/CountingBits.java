//TC:O(N*C)
class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i=0;i<=n;i++){
            int ones = setBits(i);
            res[i] = ones;
        }
        return res;
    }
    
    private int setBits(int n){
        int count = 0;
        while(n!=0){
            n=(n&n-1);
            count++;
        }
        return count;
    }
}
