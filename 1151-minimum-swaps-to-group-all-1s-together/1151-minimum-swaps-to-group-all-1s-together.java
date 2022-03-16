class Solution {
    public int minSwaps(int[] data) {
        int minimumCount = Integer.MAX_VALUE;
        
        int ones = 0;
        for(int x:data) if(x==1) ones++;
        
        if(ones < 2) return 0;
        
        int start = 0;
        int count = 0;
        for(int i=0; i<data.length; i++)
        {
            if(data[i] == 0) count++;
            if(i-start+1 == ones)
            {
                minimumCount = Math.min(minimumCount, count);
                if(data[start] == 0) count--;
                start++;
            }
        }
        
        return minimumCount;
    }
}