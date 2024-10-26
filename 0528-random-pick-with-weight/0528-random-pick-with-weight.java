class Solution {

    TreeMap<Integer, Integer> map = new TreeMap<>();
    Random rand = new Random();
    int sum = 0;
    public Solution(int[] w) {
        for(int i=0; i<w.length; i++){
            sum+=w[i];
            map.put(sum, i);
        }
    }
    
    public int pickIndex() {
        int key = map.higherKey(rand.nextInt(sum));
        return map.get(key);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */