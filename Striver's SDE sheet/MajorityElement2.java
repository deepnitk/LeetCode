//Optimal Approach
//Moore's Voting Algo
//TC: O(N) SC: O(1)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = -1;
        int num2 = -1;
        int count1 = 0;
        int count2 = 0;
        for(int el:nums) {
            if (el == num1) {
                count1 += 1;
            }
            else if ( el == num2 ) {
                count2 += 1;
            }
            else if ( count1 == 0){
                num1 = el;
                count1 += 1;
            }
            else if (count2 == 0){
                num2 = el;
                count2 += 1;
            }
            else {
                count1 -= 1;
                count2 -= 1;
            }
        }
        List<Integer> res = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for(int el: nums) {
            if(el == num1){
                count1++;
            }
            else if(el == num2) {
                count2 += 1;
            }
        }
        
        if ( count1 > nums.length/3) {
            res.add(num1);
        }
        if (count2 > nums.length/3) {
            res.add(num2);
        }
        
        return res;
    }
}
