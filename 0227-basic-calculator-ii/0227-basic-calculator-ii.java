class Solution {
    public int calculate(String s) {
        int sum = 0;
        int last = 0;
        int num = 0;
        char op = '+';
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10 + c-'0';
            }
            if((!Character.isDigit(c) && ' '!=c) || i == s.length()-1){
                if(op == '+'){
                    sum+=last;
                    last = num;
                }
                else if(op == '-'){
                    sum+=last;
                    last = -num;
                }
                else if(op == '*'){
                    last = last*num;
                }
                else{
                    last = last/num;
                }
                num = 0;
                op = c;
            }
        }
        sum+=last;
        return sum;
    }
}