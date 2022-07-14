// Summation approach | Mathematics

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] repeatedNumber(final int[] A) {
        int len = A.length;
        long s = (len * (len + 1))/2;
        long p = (len * (len + 1) * (2*len + 1))/6;
        long missingNumber = 0, repeat = 0;
        for(int i = 0; i< len; i++) {
            s -= (long)A[i];
            p -= (long)A[i] * (long)A[i];
        }
        
        missingNumber = (s + p/s)/2;
        repeat = missingNumber - s;
        int[] res = new int[2];
        res[1] = (int)missingNumber;
        res[0] = (int)repeat;
        
        return res;
    }
}
