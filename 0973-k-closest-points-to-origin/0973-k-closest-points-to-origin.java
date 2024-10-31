class Solution {
    private int[][] points;
    
    public int[][] kClosest(int[][] points, int k) {
	
        this.points = points;
        int low = 0;
        int high = 0;
		
	 // looking for the range of low and high
        for(int i = 0; i < points.length; i ++){
            high = Math.max(high, distanceCal(points[i]));
            low = Math.min(low, distanceCal(points[i]));
        }
		
        while(low <= high){
            int pivot = low + (high - low)/2;
            if(distance(pivot, k) > k){
                high = pivot - 1;
            }else
                low = pivot + 1 ;
        }
        
        int[][] res = new int[k][2];
        int j = 0;
        for(int i = 0; i < points.length; i ++){
            if(distanceCal(points[i]) < low){
                res[j ++] = points[i];
            }
        }
        return res;
    }
	
    // finding the number of points whether their distance is below threshold
    public int distance(int threshold, int k){
        int counter = 0;
        for(int[] point : points){
            if(distanceCal(point) <= threshold){
                counter ++;
            }
        }
        return counter;
    }
    
    public int distanceCal(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}