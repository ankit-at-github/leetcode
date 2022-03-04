class Solution {
    int getBit(int num)
    {
        int count = 0;
        while(num!=0)
        {
            if(num%2==1) count++;
            num/=2;
        }
        return count;
    }
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        if(n==0) return result;
        result[0] = 0;
        for(int i=1; i<=n; i++)
        {
            result[i] = getBit(i);
        }
        return result;
    }
}