class Solution {
    public String defangIPaddr(String address) {
        int n = address.length();
        StringBuilder res = new StringBuilder();
        for(int i = 0;i < n;i++) {
            if(address.charAt(i) != '.') {
                res.append(address.charAt(i));
            }
            else {
                res.append('[');
                res.append(address.charAt(i));
                res.append(']');
            }
        }
        return res.toString();
    }
}
