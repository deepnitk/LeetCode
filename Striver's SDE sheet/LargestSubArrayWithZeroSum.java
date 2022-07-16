//Optimal Approach
//TC: o(nlogn)
class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int maxi = 0;
        for(int i = 0;i<n; i++) {
            sum += arr[i];
            if (sum == 0) {
                maxi = i + 1;
            }
            else {
                if (hm.containsKey(sum)) {
                    maxi = Math.max(maxi, i - hm.get(sum));
                }
                else {
                    hm.put(sum, i);
                }
            }
        }
        return maxi;
    }
}
