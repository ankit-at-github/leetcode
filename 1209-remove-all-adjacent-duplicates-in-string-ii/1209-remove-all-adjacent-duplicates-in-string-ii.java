class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++)
        {
            if(st.isEmpty())
            {
                sb.append(s.charAt(i));
                st.push(sb.toString());
            }
            else
            {
                StringBuilder check = new StringBuilder(st.peek());
                if(check.charAt(0) == s.charAt(i))
                {
                    st.pop();
                    if(check.length() != k-1)
                    {
                        check.append(s.charAt(i));
                        st.push(check.toString());
                    }
                }
                else
                {
                    sb.append(s.charAt(i));
                    st.push(sb.toString());
                }
            }
            sb.delete(0, sb.length());
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()) ans.append(st.pop());
        ans.reverse();
        return ans.toString();
    }
}