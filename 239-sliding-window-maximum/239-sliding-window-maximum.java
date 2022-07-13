class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        int left=0, right=0;
        int[] ans = new int[nums.length-k+1];
        while(right < nums.length)
        {
            if(right-left < k)
            {
                pq.add(new int[]{nums[right], right});
                right++;
            }
            if(right-left == k)
            {
                ans[left++] = pq.peek()[0];
            }
            
            //If max element is out of window, remove all element from left till the index where max element was present.
            while(!pq.isEmpty() && pq.peek()[1] < left) pq.poll();
        }
        
        return ans;
    }
}