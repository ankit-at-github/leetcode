class Solution {
    public boolean isPossible(int[] nums) {
        PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b) {
                if (a.end == b.end) {
                    return Integer.compare(a.length, b.length);
                }
                return Integer.compare(a.end, b.end);
            }
        }); 
        
        for (int num : nums) {
            while (!pq.isEmpty() && pq.peek().end + 1 < num) {
                if (pq.poll().length < 3)
                    return false;
            }
            if (pq.isEmpty() || pq.peek().end == num) {
                pq.add(new Interval(num, num));
            } else { // pq.peek().end + 1 == num
                pq.add(new Interval(pq.poll().start, num));
            }
        }
        
        while (!pq.isEmpty()) {
            if (pq.poll().length < 3)
                return false;
        }
        
        return true;
    }
    
    class Interval {
        int start;
        int end;
        int length;
        
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
            length = end - start + 1;
        }
    }
}