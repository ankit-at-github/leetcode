class Solution {
    public int longestValidParentheses(String s) {
        if(s == null) return 0;
        
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        
        int maxi = 0;
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i) == ')')
            {
                st.pop();
                if(st.isEmpty()) st.add(i);
                else maxi = Math.max(maxi, i-st.peek());
            }
            else st.push(i);
        }
        
        return maxi;
    }
}