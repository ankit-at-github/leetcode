class Solution {
    public int minSwaps(int[] data) {
        int ones = 0;
        for(int x : data) if(x==1) ones++;
        
        int swaps = Integer.MAX_VALUE, zeroes = 0;
        int start = 0, end = 0;
        while(end<data.length)
        {
            if(data[end] == 0) zeroes++;
            
            if(end-start+1 == ones)
            {
                swaps = Math.min(swaps, zeroes);
                if(data[start] == 0) zeroes--;
                start++;
            }
            end++;
        }
        if(swaps == Integer.MAX_VALUE) return 0;
        return swaps;
    }
}