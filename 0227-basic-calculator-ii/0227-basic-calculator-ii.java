class Solution {
    public int calculate(String s) {
        //Stack<Integer> st = new Stack<>();
        int num = 0;
        int last = 0;
        int sum = 0;
        char op = '+';
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c-'0';
            }
            if((!Character.isDigit(c) && ' '!= c) || i == s.length()-1){
                if(op == '+'){
                    sum+=last;
                    last = num;
                    // st.push(num);
                }
                if(op == '-'){
                    sum+=last;
                    last = -num;
                    // st.push(-num);
                }
                if(op == '*'){
                    // st.push(st.pop() * num);
                    last = last*num;
                }
                if(op == '/'){
                    // st.push(st.pop() / num);
                    last = last/num;
                }
                op = c;
                num = 0;
            }
        }
        sum+=last;
        // int total = 0;
        // while(!st.isEmpty()){
        //     total+=st.pop();
        // }
        return sum;
    }
}