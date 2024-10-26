class Solution {

    int[] nums;
    Random rand = new Random();
    int total = 0;
    public Solution(int[] w) {
        this.nums = new int[w.length];
        int runningTotal = 0;
        for(int i=0; i<w.length; i++){
            runningTotal+=w[i];
            nums[i] = runningTotal;
        }
        this.total = runningTotal;
    }
    
    public int pickIndex() {
        int n = rand.nextInt(total);
        //this n will either exist in array or it wont, we need to return close index to n
        for(int i=0; i<nums.length; i++){
            if(n < nums[i]) return i;
        }
        return -1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */