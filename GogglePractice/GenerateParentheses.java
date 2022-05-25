class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        utils(n, 0, 0,res, new StringBuilder());
        return res;
    }
    
  	public void utils(int n , int open, int close, List<String> res, StringBuilder s) {
		if(open == n && close == n) {
			res.add(s.toString());
			return;
		}
		
		if(open < n) {
			s.append('(');
			utils(n, open + 1, close, res, s);
			s.deleteCharAt(s.length() - 1);
		}
		if(close < open) {
			s.append(')');
			utils(n, open, close + 1, res,s);
			s.deleteCharAt(s.length() - 1);
		}
	}
}
