class DetectSquares {
    Map<String, Integer> counts;
    List<int[]> coordinates;
    public DetectSquares() {
        counts = new HashMap<>();
        coordinates = new ArrayList();
    }
    
    public void add(int[] point) {
        coordinates.add(point);
        String key = point[0] + "#" + point[1];
        counts.put(key, counts.getOrDefault(key, 0) + 1);
    }
    
    public int count(int[] point) {
        int sum = 0;
        int qx = point[0], qy = point[1];
        for(int[] coordinate : coordinates){
            int x = coordinate[0];
            int y = coordinate[1];
            //Condition to form square: Height difference of y = Height difference of x
            if(x == qx || y == qy || Math.abs(x - qx) != Math.abs(y - qy)) continue;
            
            sum+=counts.getOrDefault((x + "#" + qy), 0) * counts.getOrDefault((qx + "#" + y), 0);
        }
        return sum;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */