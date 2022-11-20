class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray())
        {
            if(!st.isEmpty() && ch==')')
            {
                if(st.peek() == '(') st.pop();
                else return false;
            }
            else if(!st.isEmpty() && ch=='}')
            {
                if(st.peek() == '{') st.pop();
                else return false;
            }
            else if(!st.isEmpty() && ch==']')
            {
                if(st.peek() == '[') st.pop();
                else return false;
            }
            else st.push(ch);
        }
        return st.size()==0?true:false;
    }
}