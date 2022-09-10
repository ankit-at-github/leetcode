class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++)
        {
            if(!st.isEmpty() && s.charAt(i) == ')')
            {
                if(st.peek() == '(') st.pop();
                else return false;
            }
            else if(!st.isEmpty() && s.charAt(i) == '}')
            {
                if(st.peek() == '{') st.pop();
                else return false;
            }
            else if(!st.isEmpty() && s.charAt(i) == ']')
            {
                if(st.peek() == '[') st.pop();
                else return false;
            }
            else st.add(s.charAt(i));
        }
        return st.size()==0?true:false;
    }
}