class Solution {

    int[] prefixSum;
    Random rand;
    int total = 0;
    public Solution(int[] w) {
        prefixSum = new int[w.length];
        rand = new Random();
        int runningTotal = 0;
        for(int i=0; i<w.length; i++){
            runningTotal+=w[i];
            prefixSum[i] = runningTotal;
        }
        this.total = runningTotal;
    }
    
    public int pickIndex() {
        int n = rand.nextInt(total) + 1;
        int low = 0, high = prefixSum.length-1;
        while(low <= high){
            int mid = low + (high-low) / 2;
            
            if(prefixSum[mid] < n) low = mid+1;
            else high = mid - 1;
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */