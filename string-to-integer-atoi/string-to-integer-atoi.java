class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;
        int sign = 1, start = 0;
        if(s.charAt(0) == '+') start++;
        else if(s.charAt(0) == '-')
        {
            sign = -1;
            start = 1;
        }
        long sum = 0;
        for(int i=start; i<s.length(); i++)
        {
            if(!Character.isDigit(s.charAt(i))) return (int)sum*sign;
            sum = sum*10 + s.charAt(i) - '0'; 
            
            //Positive Range
            if(sign == 1 && sum > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            
            //Negative Range
            if(sign == -1 && sign*sum < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        if(sign == -1) return (int)sum*-1;
        return (int)sum;
    }
}