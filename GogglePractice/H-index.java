//TC: o(nlogn)
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int res = 1;
        for(int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] >= res) {
                res += 1;
            }
        }
        return res - 1;
    }
}
