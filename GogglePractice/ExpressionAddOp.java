//BackTracking Solution
class Solution {
    private List<String> res = new ArrayList<>();
    
    public List<String> addOperators(String num, int target) {
        addOperatorsUtils(0, "", 0, 0, num, target);
        return res;
    }
    
    private void addOperatorsUtils(int idx, String path, long resSoFar, long prevNum, String s, int target) {
        if ( idx == s.length() ) {
            if ( resSoFar == target ) {
                res.add(path);
                return;
            }
        }
        
        for( int j = idx; j < s.length(); j++) {
            if (j > idx && s.charAt(idx) == '0') {
                break;
            }
            long currNum = Long.parseLong(s.substring(idx, j + 1));
            if ( idx == 0) {
                addOperatorsUtils(j + 1, path + currNum, currNum, currNum, s, target);
            }
            else {
                addOperatorsUtils(j + 1, path + "+" + currNum, resSoFar + currNum, +currNum, s, target);
                addOperatorsUtils(j + 1, path + "-" + currNum, resSoFar - currNum, -currNum, s, target);
                addOperatorsUtils(j + 1, path + "*" + currNum, resSoFar - prevNum + prevNum * currNum, prevNum * currNum, s, target);
            }
        }
    }
}
