/*
Time Complexity: O( (2^n) *k*(n/2) )
Reason: O(2^n) to generate every substring and O(n/2)  to check if the substring generated is a palindrome. 
O(k) is for inserting the palindromes in another data structure, where k  is the average length of the palindrome list.
Space Complexity: O(k * x)
Reason: The space complexity can vary depending upon the length of the answer. 
k is the average length of the list of palindromes and if we have x such list of palindromes in our final answer. 
The depth of the recursion tree is n, so the auxiliary space required is equal to the O(n).
*/
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        partitionUtils(0, s, path, res);
        return res;
    }
    
    private void partitionUtils(int idx, String s, List<String> path, List<List<String>> res) {
        if ( idx == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = idx;i < s.length(); i++) {
            if ( isPallindrome(s,idx, i) ) {
                path.add(s.substring(idx, i + 1));
                partitionUtils(i + 1, s, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isPallindrome(String s, int start, int end) {
        while (start <= end) {
            if ( s.charAt(start++) != s.charAt(end--) ) {
                return false;
            }
        }
        return true;
    }
}
