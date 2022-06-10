//Naive approach
class Solution {
    public int hIndex(int[] citations) {
        int res = 1;
        for(int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] >= res) {
                res += 1;
            }
        }
        return res - 1;
    }
}

//Optimal Solution
//TC: O(logn)

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int lo = 0;
        int hi = n - 1;

        while ( lo <= hi ) {
            int mid = lo + (hi - lo)/2;
            if (citations[mid] == n - mid){
                return citations[mid];
            }
            else if (citations[mid] > n - mid){
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        return n - lo;
    }
}
