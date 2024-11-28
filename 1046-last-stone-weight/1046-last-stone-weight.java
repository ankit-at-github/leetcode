class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int stone : stones) pq.add(stone);
        while(pq.size() > 1){
            int a = pq.poll();
            int b = pq.poll();
            if(a != b){
                a = a > b ? a-b : b - a;
                pq.add(a);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}