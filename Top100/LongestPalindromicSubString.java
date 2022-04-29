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
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n==0) return "";
        StringBuilder longestPalin = new StringBuilder();
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=i;j<n;j++){
                sb.append(s.charAt(j));
                if(isPalindrome(sb.toString())){                
                    if(longestPalin.toString().length()<sb.toString().length())
                            longestPalin=sb;     
                }

            }
        }
        return longestPalin.toString();
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
