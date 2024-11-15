class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == ')'){
                if(st.isEmpty() || st.peek() != '(') return false;
                st.pop();
            }
            else if(c == '}'){
                if(st.isEmpty() || st.peek() != '{') return false;
                st.pop();
            }
            else if(c == ']'){
                if(st.isEmpty() || st.peek() != '[') return false;
                st.pop();
            }
            else st.push(c);
        }
        
        return st.isEmpty();
    }
}