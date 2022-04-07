class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int x : stones) pq.add(x);
        while(!pq.isEmpty() && pq.size()!=1)
        {
            int y = pq.poll();
            int x = pq.poll();
            if(y!=x) pq.add(y-x);
        }
        return pq.size()==1?pq.poll():0;
    }
}