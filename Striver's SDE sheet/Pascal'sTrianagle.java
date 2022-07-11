//TC: O(N2)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        
        for (int i = 0;i < numRows; i++) {
            curr = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    curr.add(1);
                }
                else {
                    curr.add(pre.get(j-1) + pre.get(j));
                }
            }
            pre = curr;
            res.add(curr);
        }
        return res;
    }
}

/*
Other variant of problemn
1. value of (5,3)th element of pascal's Trianage
    answer = r-1 (C) c-1
2. return nth row of pascal's triangle
    need to calculate  nCr for n elements and store
    Optimization:
        for(int i = 0; i< k; i++) {
            res *= (n - i);
            res /= (i + 1);
            
        }
*/        
