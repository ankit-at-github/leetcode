class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        for(int i=0; i<n; i++){
            cars[i] = new double[]{position[i], (double)(target - position[i]) / speed[i]};
        }
        
        Arrays.sort(cars, (a,b) -> Double.compare(a[0], b[0]));
        
        double current = 0;
        int fleet = 0;
        for(int i = n-1; i >= 0; i--){
            if(cars[i][1] > current){
                current = cars[i][1];
                fleet++;
            }
        }
        return fleet;
    }
}