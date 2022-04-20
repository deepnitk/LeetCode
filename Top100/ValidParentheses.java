class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            else {
              
                //Corner Case: if String is having a closing parenthesis and stack is empty() return false
                if(st.isEmpty()) return false;
                
                if(ch == ')' && st.peek() == '(') st.pop();
                else if(ch == '}' && st.peek() == '{') st.pop();
                else if(ch == ']' && st.peek() == '[' ) st.pop();
                else return false;
            }
        }
      
        //Corner Case: String with only open parenthesis "["
        if(!st.isEmpty()) return false;
        
        return true;
    }
}
//TC:O(N)
//SC:O(N) -- stack
