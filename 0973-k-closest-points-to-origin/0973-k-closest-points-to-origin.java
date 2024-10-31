class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int low = 0;
        int high = 0;
        for(int[] point : points){
            low = Math.min(low, distanceCal(point));
            high = Math.max(high, distanceCal(point));
        }
        while(low <= high){
            int mid = low + (high-low) / 2;
            
            if(count(points, mid, k) > k) high = mid-1;
            else low = mid+1;
            
        }
        int[][] ans = new int[k][2];
        int index = 0;
        for(int i=0; i<points.length; i++){
            if(distanceCal(points[i]) < low){
                ans[index++] = points[i];
            }
        }
        return ans;
    }
    public int count(int[][] points, int threshold, int k){
        int counter = 0;
        for(int[] point : points){
            if(distanceCal(point) <= threshold){
                counter ++;
            }
        }
        return counter;
    }
    public int distanceCal(int[] point){
        return point[0]*point[0] + point[1]*point[1];
    }
}