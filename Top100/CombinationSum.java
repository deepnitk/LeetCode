//Recursive solution
//TC: o(2^t)*k

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSumUtils(0, candidates, target, res, new ArrayList<>());
        return res;
    }
    
    public void combinationSumUtils(int idx, int[] arr, int target, List<List<Integer>> res, List<Integer> ds) {
        // Base case
        if(idx == arr.length){
            if(target == 0){
                res.add(new ArrayList<>(ds));
            }
            return;
        }
        
        //Pick case
        if (arr[idx] <= target){
            ds.add(arr[idx]);
            combinationSumUtils(idx, arr, target-arr[idx], res, ds);
            ds.remove(ds.size()-1);
        }
        
        //not pick case
        combinationSumUtils(idx+1, arr, target, res, ds);
        
    }
}
