class Solution {
    public int[] sortByBits(int[] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]==b[1]?a[0]-b[0]:a[1]-b[1]);
        for(int x : arr)
        {
            int hw = hammingWeight(x);
            pq.add(new int[]{x, hw});
        }
        
        int[] result = new int[arr.length];
        int index = 0;
        while(!pq.isEmpty())
        {
            result[index++] = pq.poll()[0];
        }
        return result;
    }
    public int hammingWeight(int x)
    {
        int count = 0;
        while(x!=0)
        {
            count++;
            x&=x-1;
        }
        return count;
    }
}