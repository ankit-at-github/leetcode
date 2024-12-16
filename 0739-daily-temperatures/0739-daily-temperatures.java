class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        int hottest = -1;
        for(int i= n - 1; i >= 0; i--){
            if(temperatures[i] >= hottest){
                hottest = temperatures[i];
                continue;
            }
            
            int days = 1;
            while(temperatures[i + days] <= temperatures[i]){
                days += ans[i + days];
            }
            ans[i] = days;
        }
        return ans;
    }
}