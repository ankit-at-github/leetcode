class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        int[] climb = new int[n+1];
        climb[0] = 0; climb[1] = 1; climb[2] = 2;
        for(int i=3; i<n+1; i++) climb[i] = climb[i-1] + climb[i-2];
        return climb[n];
    }
}