//Brute Force
//TC:0(N^3)
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n==0) return "";
        StringBuilder res = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                StringBuilder sb = new StringBuilder();
                for(int k=i;k<=j;k++){
                    sb.append(s.charAt(k));
                }
                if(isPalindrome(sb.toString())){
                    if(res.toString().length()<sb.toString().length()){
                        res=sb;
                    }
                }
            }
        }
        return res.toString();
    }
    
    private boolean isPalindrome(String s){
        int n = s.length();
        int left=0, right=n-1;
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}

//Better solution
//TC:O(N2)
//SC:O(1)
class Solution {
    public String longestPalindrome(String s) {
        //s = defabbadjk"
        int n = s.length();
        int start = 0;
        int end = 0;
        for(int i=0;i<n;i++){
            int len1 = expandFromMiddle(s, i, i);
            int len2 = expandFromMiddle(s, i,i+1);
            int len = Math.max(len1, len2);
            
            if (len>end-start){
                start = i -((len-1)/2);
                end = i + (len/2);
            }
        }
        return s.substring(start, end+1);
    }
    
    public int expandFromMiddle(String s, int left, int right){
        if (s == null || left> right) {
            return 0;
        }
        while(left>=0 && right< s.length()
             && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left -1;
        
    }
}


