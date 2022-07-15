class Solution {
    public int romanToInt(String s) {
        int value = 0;
        int i = s.length()-1;
        for(; i>=1; i--)
        {
            if(s.charAt(i) == 'I')
                value+=1;
            else if(s.charAt(i) == 'V')
            {
                if(s.charAt(i-1) == 'I')
                {
                    value+=4;
                    i--;
                }
                else value+=5;
            }
            else if(s.charAt(i) == 'X')
            {
                if(s.charAt(i-1) == 'I')
                {
                    value+=9;
                    i--;
                }
                else value+=10;
            }
            else if(s.charAt(i) == 'L')
            {
                if(s.charAt(i-1) == 'X')
                {
                    value+=40;
                    i--;
                }
                else value+=50;
            }
            else if(s.charAt(i) == 'C')
            {
                if(s.charAt(i-1) == 'X')
                {
                    value+=90;
                    i--;
                }
                else value+=100;
            }
            else if(s.charAt(i) == 'D')
            {
                if(s.charAt(i-1) == 'C')
                {
                    value+=400;
                    i--;
                }
                else value+=500;
            }
            else if(s.charAt(i) == 'M')
            {
                if(s.charAt(i-1) == 'C')
                {
                    value+=900;
                    i--;
                }
                else value+=1000;
            }
        }
        if(i == 0)
        {
            if(s.charAt(0) == 'I') value+=1;
            else if(s.charAt(0) == 'V') value+=5;
            else if(s.charAt(0) == 'X') value+=10;
            else if(s.charAt(0) == 'L') value+=50;
            else if(s.charAt(0) == 'C') value+=100;
            else if(s.charAt(0) == 'D') value+=500;
            else value+=1000;
        }
        
        return value;
    }
}