class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int t : time)
        {
            int rem = t % 60;
            if(map.containsKey(60 - rem)) count+=map.get(60 - rem);
            if(rem == 0) map.put(60, map.getOrDefault(60, 0)+1);
            map.put(rem, map.getOrDefault(rem, 0)+1);
        }
        return count;
    }
}