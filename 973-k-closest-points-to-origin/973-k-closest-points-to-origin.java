class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> ((b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])) );
        
        for(int[] point : points)
        {
            maxHeap.add(point);
            if(maxHeap.size() > k) maxHeap.poll();
        }
        
        int[][] result = new int[k][2];
        int index = 0;
        while(maxHeap.size()!=0)
        {
            result[index] = maxHeap.poll();
            index++;
        }
        
        return result;
    }
}
