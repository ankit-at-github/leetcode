class Solution {
    public int reverse(int x) {
        int sign = 1;
        if(x < 0){
            sign = -1;
            x = x*-1;
        }
        long num = 0;
        while(x > 0){
            int r = x % 10;
            num = num * 10 + r;
            if(num > Integer.MAX_VALUE) return 0;
            x = x / 10;
        }
        if(sign == -1) return (int) num * -1;
        return (int) num;
    }
}