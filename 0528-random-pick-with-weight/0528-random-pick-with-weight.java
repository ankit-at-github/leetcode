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
        int n = rand.nextInt(total) + 1;
        //this n will either exist in array or it wont, we need to return close index to n
        int left = 0, right = nums.length-1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(n > nums[mid]) left = mid+1;
            else right = mid;
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */