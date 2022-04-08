class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        for(int x : nums1) maxHeap.add(x);
        Queue<Integer> minHeap = new PriorityQueue<>((a,b) -> a-b);
        for(int x : nums2) minHeap.add(x);
        
        int sum = 0;
        while(maxHeap.size() > 0)
        {
            sum+= maxHeap.poll()*minHeap.poll();
        }
        
        return sum;
        
    }
}