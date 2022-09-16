class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int maxi = 0;
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i) == ')')
            {
                maxi = Math.max(maxi, st.size());
                st.pop();
            }
            if(s.charAt(i) == '(') st.add('(');
        }
        return maxi;
    }
}