class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] rem = new int[60];
        
        int songs = 0;
        for(int n : time)
        {
            int x = n % 60;
            if(x==0)
            {
                songs+=rem[0];
            }
            else
            {
                songs+=rem[60-x];
            }
            rem[x]++;
        }
        
        return songs;
    }
}