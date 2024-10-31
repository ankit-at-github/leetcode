class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        int open = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                st.push(i);
                open++;
            }
            else if(c == ')'){
                if(open == 0) st.push(i);
                else{
                    st.pop();
                    open--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--){
            if(!st.isEmpty() && st.peek() == i) st.pop();
            else sb.append(s.charAt(i));
        }
        return sb.reverse().toString();
    }
}