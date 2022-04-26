//TC:O(N*Log(MAX))
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

//TC:O(N)
//Right shift by 1
class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        res[0] = 0;
        for(int i=1;i<=n;i++){
            // here i/2 means right shift by 1 bit. 
            // for e.g noOfSetBits of 5(101) = noOfSetBits(5/2) + 5%2 = 1+1 = 2
            // noOfSetBits of 6(110) = noOfSetBits of(6/2) + 6%2 = 2 + 0 = 2 
            res[i]=res[i/2]+(i%2);
        }
        return res;
    }
}

