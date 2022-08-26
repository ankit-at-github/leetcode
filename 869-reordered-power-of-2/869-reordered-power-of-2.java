class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] digit = new int[10];
        count(n, digit);
        int num = 1;
        for(int i=0; i<31; i++)
        {
            int[] temp = new int[10];
            count(num, temp);
            if(Arrays.equals(digit, temp)) return true;
            num = num << 1;
        }
        return false;
    }
    public void count(int n, int[] digit)
    {
        while(n > 0)
        {
            digit[n%10]++;
            n/=10;
        }
    }
}