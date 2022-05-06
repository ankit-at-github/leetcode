class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        for(int i=0; i<s.length(); i++)
        {
            if(st.isEmpty() || s.charAt(i) != st.peek().c)
            {
                st.push(new Pair(s.charAt(i), 1));
            }
            else
            {
                if(++st.peek().count == k) st.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
        {
            Pair p = st.pop();
            for(int i=0; i<p.count; i++)
            sb.append(p.c);
        }
        sb.reverse();
        return sb.toString();
    }
    class Pair{
        int count;
        char c;
        Pair(char _c, int _count)
        {
            c = _c;
            count = _count;
        }
    }
}