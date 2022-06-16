//Optimal
/*
Time Complexity: O(N) * O(N) = O(N^2)
Reason: We are placing N numbers in N positions. This will take O(N) time. For every number, 
we are reducing the search space by removing the element already placed in the previous step. This takes another O(N) time.
Space Complexity: O(N) 
Reason: We are storing  the numbers in a data structure(here vector)
*/

class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> nums = new ArrayList<>();
        //Calculating fact(n - 1)
        for(int i = 1;i < n;i++){
            fact *= i;
            nums.add(i);
        }
        nums.add(n);
        String ans = "";
        k = k - 1;
        while ( true ){
            ans = ans + "" + nums.get(k / fact);
            nums.remove(k / fact);
            if ( nums.size() == 0) {
                break;
            }
            k = k % fact;
            fact = fact/nums.size();
        }
        return ans;
    }
}
