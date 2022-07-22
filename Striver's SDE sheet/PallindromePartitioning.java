class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        partitionUtils(0, n, s, path, res);
        return res;
    }
    
    private void partitionUtils(int idx, int n, String s, List<String> path, List<List<String>> res) {
        if (idx == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = idx;i < n;i++) {
            if( isPallindrome(s, idx, i) ) {
                path.add(s.substring(idx, i + 1));
                partitionUtils(i + 1, n, s, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
    
    private boolean isPallindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
