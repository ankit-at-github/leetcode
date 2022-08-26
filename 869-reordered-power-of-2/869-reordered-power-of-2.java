class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] digit = new int[10];
        count(n, digit);
        for(int i=0; i<31; i++)
        {
            int powerOfTwo = (int)Math.pow(2, i);
            int[] temp = new int[10];
            count(powerOfTwo, temp);
            if(Arrays.equals(digit, temp)) return true;
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