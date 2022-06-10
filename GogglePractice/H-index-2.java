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
