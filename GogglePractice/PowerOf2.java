class Solution {
    public boolean isPowerOfTwo(int n) {
        if ( n >= Integer.MAX_VALUE || n <= Integer.MIN_VALUE)
            return false;
        int num = noOfSetBits(n);
        return num == 1 ? true : false;
    }
    int noOfSetBits(int n) {
        int count = 0;
        for (int i = 0; i< 32; i++){
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }
}
