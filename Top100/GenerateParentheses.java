class Solution {
    
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        // parameters are (output_arr, curr_string as empty, no. of opening parenthesis, no of closing parenthesis, n)
        backTracking(res, "", 0, 0, n);
        return res;
    }
    
    public void backTracking(List<String> output_array, String currentString, int noOfOpen, int noOfClose, int max){
        //Base case
        if (currentString.length() == max*2) {
            output_array.add(currentString);
            return;
        }
        
        //decisions
        if (noOfOpen < max) {
            backTracking(output_array, currentString + "(", noOfOpen + 1, noOfClose, max);
        }
        if (noOfClose < noOfOpen) {
            backTracking(output_array, currentString + ")", noOfOpen, noOfClose + 1, max);
        }
    }
}
