class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--)
        {
            if(s.charAt(i) == '[')
            {
                StringBuilder temp = new StringBuilder();
                while(!st.peek().equals("]"))
                {
                    temp.append(st.pop());
                }
                st.pop();
                st.push(temp.toString());
            }
            else if(Character.isDigit(s.charAt(i)))
            {
                StringBuilder num = new StringBuilder();
                while(i >= 0 && Character.isDigit(s.charAt(i)))
                {
                    num.append(s.charAt(i));
                    i--;
                }
                num = num.reverse();
                int n = Integer.valueOf(num.toString());
                String t = st.pop();
                StringBuilder temp = new StringBuilder();
                for(int j=0; j<n; j++) temp.append(t);
                st.push(temp.toString());
                i++;
            }
            else
            {
                st.push(Character.toString(s.charAt(i)));
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()) ans.append(st.pop());
        return ans.toString();
    }
}