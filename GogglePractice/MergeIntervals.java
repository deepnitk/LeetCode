//Brute force
//TC: O(nlogn)
//SC: O(N)
class Solution {
    public int[][] merge(int[][] intervals) {
        Stack<int[]> st = new Stack();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        st.push(intervals[0]);
        for(int i = 1; i<intervals.length ; i++) {
            int[] top = st.peek();
	
           // Overlapping interval
            if (top[1] >= intervals[i][0]) {
                st.pop();
                top[1] = Math.max(top[1], intervals[i][1]);
                st.push(top);
            }
            else {
                st.push(intervals[i]);
            }
        }
        int[][] res = new int[st.size()][2];
        int i = 0;
        while(!st.isEmpty()) {
            int[] top = st.pop();
            res[i][0] = top[0];
            res[i][1] = top[1];
            i++;
        }
         return res;
    }
}
