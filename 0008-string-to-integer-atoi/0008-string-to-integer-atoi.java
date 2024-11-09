class Solution {
    public int myAtoi(String s) {
        long num = 0;
        int sign = 1;
        int index = 0;
        
        if(s.length() == 0) return 0;
        
        //1. Remove all leading spaces;
        while(index < s.length() && s.charAt(index) == ' ') index++;
        
         if (index == s.length()) return 0;
        
        //2. Get Sign
        if(s.charAt(index) == '-' || s.charAt(index) == '+'){
            sign = s.charAt(index) == '-' ? -1 : 1;
            index++;
        }
        
        //3. Get digits
        while(index < s.length()){
            int digit = s.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;
            num = num*10 + digit;
            
            if(num > Integer.MAX_VALUE){
                if(sign == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            index++;
        }
        num = num * sign;
        return (int) num;
    }
}