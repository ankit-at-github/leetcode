class Pair{
    int distance;
    int index;
    Pair(int _distance, int _index){
        distance = _distance;
        index = _index;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.distance - b.distance);
        for(int i=0; i<points.length; i++){
            int distance = getEdistance(points[i][0], points[i][1]);
            pq.add(new Pair(distance, i));
        }
        int[][] ans = new int[k][2];
        int index = 0;
        while(k > 0){
            Pair p = pq.poll();
            ans[index][0] = points[p.index][0];
            ans[index][1] = points[p.index][1];
            index++;
            k--;
        }
        return ans;
    }
    public int getEdistance(int x1, int y1){
        int val = x1*x1 + y1*y1;
        return val;
    }
}