//Brute Force
//TC(N*K)

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int r = 0;
        for(int i =  0; i< (n - k + 1); i++) {
            int maxi = nums[i];
            for (int j = i; j <= (i + k -1); j++) {
                maxi = Math.max(maxi, nums[j]);
            }
            res[r] = maxi;
            r++;
        }
        return res;
    }
}

//Optimal sulution using Deque
// TC: O(N) + O(N) ~ O(N)
// SC: O(K)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int r = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i< n; i++) {
            //remove from front if they are not in range
            while ( !dq.isEmpty() && dq.peek() == (i - k)) {
                dq.poll();
            }
            //remove smaller element in k ranges as they are useless
            while ( !dq.isEmpty() && nums[i] > nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offer(i);
            if ( i >= k - 1) {
                res[r++] = nums[dq.peek()];
            }
        }
        return res;
    }
}
