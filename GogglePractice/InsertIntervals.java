//tc:o(n)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {        
        ArrayList<int[]> res = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++) {
            // non overlapping cases
            //1. newInterval's end is less than start of currentInterval, so add newInterval to res
            if(newInterval[1] < intervals[i][0]) {
                res.add(newInterval);
                while(i < intervals.length) {
                    res.add(intervals[i]);
                    i++;
                    
                }
                return res.toArray(new int[0][]);
            }
            // 2. newInterval's start is greater than currentInterval's end, so add currentInterval to res
            else if(newInterval[0] > intervals[i][1]) {
                res.add(intervals[i]);
            }
            //Overlapping case
            else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        res.add(newInterval);
        return res.toArray(new int[0][]);
    }
}
