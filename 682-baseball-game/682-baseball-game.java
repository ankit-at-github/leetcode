class Solution {
    public int calPoints(String[] ops) {
        Stack<String> st = new Stack<>();
        for(String s : ops)
        {
            if(s.equals("C"))
            {
                st.pop();
            }
            else if(s.equals("D"))
            {
                st.push(Integer.toString(Integer.parseInt(st.peek())*2));
            }
            else if(s.equals("+"))
            {
                String a = st.pop();
                String b = st.pop();
                st.push(b);
                st.push(a);
                st.push(Integer.toString(Integer.parseInt(a)+Integer.parseInt(b)));
            }
            else
            {
                st.push(s);
            }
        }
        
        int sum = 0;
        while(!st.isEmpty())
        {
            sum+=Integer.parseInt(st.pop());
        }
        
        return sum;
    }
}