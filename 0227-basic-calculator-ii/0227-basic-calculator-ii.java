class Solution {
    public int calculate(String s) {
        int last = 0;
        char op = '+';
        int num = 0;
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = num*10 + c-'0';
            }
            
            if((!Character.isDigit(c) && ' '!= c) || i == s.length()-1){
                if(op == '+'){
                    sum+=last;
                    last = num;
                }
                if(op == '-'){
                    sum+=last;
                    last = -num;
                }
                if(op == '*'){
                    last*=num;
                }
                if(op == '/'){
                    last/=num;
                }
                op = c;
                num = 0;
            }
        }
        sum+=last;
        return sum;
    }
}