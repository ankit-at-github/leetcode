class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> exp = new Stack<>();
        for(String s : tokens)
        {
            if(s.equals("+"))
            {
                int a = Integer.parseInt(exp.pop());
                int b = Integer.parseInt(exp.pop());
                exp.push(Integer.toString(a+b));
            }
            else if(s.equals("-"))
            {
                int a = Integer.parseInt(exp.pop());
                int b = Integer.parseInt(exp.pop());
                exp.push(Integer.toString(b-a));
            }
            else if(s.equals("*"))
            {
                int a = Integer.parseInt(exp.pop());
                int b = Integer.parseInt(exp.pop());
                exp.push(Integer.toString(a*b));
            }
            else if(s.equals("/"))
            {
                int a = Integer.parseInt(exp.pop());
                int b = Integer.parseInt(exp.pop());
                exp.push(Integer.toString(b/a));
            }
            else exp.push(s);
        }
        return Integer.parseInt(exp.pop());
    }
}