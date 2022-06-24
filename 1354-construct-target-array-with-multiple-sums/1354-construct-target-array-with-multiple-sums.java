class Solution {
    public boolean isPossible(int[] target) {
        
        // Handle the n = 1 case.
        if (target.length == 1) {
            return target[0] == 1;
        }
        
        int totalSum = Arrays.stream(target).sum();
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int num : target) {
            pq.add(num);
        }
        
        while (pq.element() > 1) {
            int largest = pq.remove();
            int rest = totalSum - largest;
            
            // This will only occur if n = 2.
            if (rest == 1) {
                return true;
            }
            int x = largest % rest;
            
            // If x is now 0 (invalid) or didn't
            // change, then we know this is impossible.
            if (x == 0 || x == largest) {
                return false;
            }
            pq.add(x);
            totalSum = totalSum - largest + x;
        }
        
        return true; 
    }
}