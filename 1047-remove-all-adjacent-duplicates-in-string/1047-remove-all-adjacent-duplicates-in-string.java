class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        int i = s.length()-1;
        while(i>=0)
        {
            if(st.isEmpty())
            {
                st.add(s.charAt(i));
            }
            else
            {
                if(s.charAt(i) == st.peek()) st.pop();
                else st.add(s.charAt(i));
            }
            i--;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop());
        return sb.toString();
    }
}