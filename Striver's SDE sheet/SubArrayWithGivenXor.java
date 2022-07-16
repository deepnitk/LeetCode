//Optimal approach
//TC:O(NLOGN)
public class Solution {
    public int solve(int[] A, int B) {
        int xorr = 0; 
        int cnt = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < A.length; i++) {
            xorr ^= A[i];
            if ( hm.containsKey(xorr ^ B)) {
                cnt += hm.get(xorr ^ B);
            }
            if(xorr == B) {
                cnt += 1;
            }
            if (hm.containsKey(xorr)) {
                hm.put(xorr, hm.get(xorr) + 1);
            }
            else {
                hm.put(xorr, 1);
            }
        }
        return cnt;
    }
}
