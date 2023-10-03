class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] map = new int[101];
        for(int n : nums) map[n]++;
        int total = 0;
        for(int i=1; i<=100; i++)
        {
            if(map[i] > 1) total+=pairs(map[i]);
        }
        return total;
    }
    public int pairs(int n){
        return (n*(n-1))/2;
    }
}