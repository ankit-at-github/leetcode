class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for(int i=0; i<points.length; i++){
            int distance = getEdistance(points[i]);
            pq.add(new int[]{distance, i});
            if(pq.size() > k) pq.poll();
        }
        int[][] ans = new int[k][2];
        for(int i=0; i<k; i++){
            int index = pq.poll()[1];
            ans[i] = points[index];
        }
        return ans;
    }
    public int getEdistance(int[] point){
        return point[0]*point[0] + point[1]*point[1];
    }
}