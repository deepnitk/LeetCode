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

//Better approach
//tc : o(nlogn) + o(n)
//sc: o(1)
class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        if(intervals.length == 0 || intervals == null)
            return res.toArray(new int[0][]);
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int[] interval: intervals) {
            if(end >= interval[0]) {
                end = Math.max(end, interval[1]);
            }
            else {
                res.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[0][]);
    }
}
