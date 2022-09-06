class Leaderboard {
    Map<Integer, Integer> board = new HashMap<>();
    public Leaderboard() {
        
    }
    
    public void addScore(int playerId, int score) {
        board.put(playerId, board.getOrDefault(playerId, 0)+score);
    }
    
    public int top(int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(Map.Entry<Integer, Integer> entry : board.entrySet()) pq.add(entry.getValue());
        
        int sum = 0;
        while(K-- > 0 && !pq.isEmpty()) sum+=pq.poll();
        return sum;
    }
    
    public void reset(int playerId) {
        board.put(playerId, 0);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */