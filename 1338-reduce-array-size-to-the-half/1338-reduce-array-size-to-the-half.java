class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int x : arr) freq.put(x, freq.getOrDefault(x, 0)+1);
        
        if(freq.size() == 1) return 1;
        
        if(freq.size() == arr.length) return arr.length/2;
        
        int[][] pair = new int[freq.size()][2];
        int index = 0;
        for(Map.Entry<Integer, Integer> entry : freq.entrySet())
        {
            pair[index][0] = entry.getValue();
            pair[index++][1] = entry.getKey();
        }
        
        Arrays.sort(pair, ((a,b) -> b[0]-a[0]));
        
        int size = 0, mini = 0;
        for(int[] count : pair)
        {
            size+=count[0];
            mini++;
            if(size >= arr.length/2) return mini;
        }
        return -1;
    }
}