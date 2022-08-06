class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        int[] rem = new int[60];
        for(int t : time)
        {
            int x = t % 60;
            if(x == 0) count+=rem[x];
            else count+=rem[60-x];
            rem[x]++;
        }
        return count;
    }
}