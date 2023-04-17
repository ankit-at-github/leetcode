class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        int sign = 1, start = 0;
        
        if(s.length() == 0) return 0;
        
        if(s.charAt(0) == '+') start = 1;
        if(s.charAt(0) == '-')
        {
            sign = -1;
            start = 1;
        }
        
        long num = 0;
        
        for(int i=start; i<s.length(); i++)
        {
            if(!Character.isDigit(s.charAt(i))) return (int)(sign*num);
            
            num = num*10 + s.charAt(i) - '0';
            
            //Negative Range
            if(sign == -1 && sign*num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            
            //Positive Range
            if(sign == 1 && sign*num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
        
        if(sign == -1) return (int)(sign*num);
        return (int)num;
    }
}