class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]));
        
        for(int[] point : points)
        {
            pq.add(point);
        }
        int[][] result = new int[k][2];
        int index = 0;
        while(k > 0)
        {
            int[] value = pq.poll();
            result[index][0] = value[0];
            result[index][1] = value[1];
            index++;
            k--;
        }
        
        return result;
    }
}