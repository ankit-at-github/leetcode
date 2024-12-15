class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        for(char c : tasks){
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        maxHeap.addAll(freq.values());
        
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        while(!maxHeap.isEmpty() || !q.isEmpty()){
            time++;
            
            int task = maxHeap.isEmpty() ? 0 : maxHeap.poll() - 1;
            if(task != 0){
                q.add(new int[]{task, time + n});
            }
            
            if(!q.isEmpty() && q.peek()[1] == time){
                maxHeap.add(q.poll()[0]);
            }
        }
        return time;
    }
}