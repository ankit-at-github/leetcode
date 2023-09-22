class Solution {
    public boolean isSubsequence(String s, String t) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()) st.add(c);
        for(int i=t.length()-1; i>=0; i--)
        {
            if(!st.isEmpty() && t.charAt(i) == st.peek()) st.pop();
        }
        if(!st.isEmpty()) return false;
        return true;
    }
}