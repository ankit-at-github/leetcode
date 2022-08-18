class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //Optimized approach using Deque
        int[] ans = new int[nums.length-k+1];
        Deque<Integer> dq = new LinkedList<>();
        int left = 0, right = 0;
        while(right < nums.length)
        {
            while(!dq.isEmpty() && nums[right] > nums[dq.peekLast()]) dq.pollLast();
            
            dq.addLast(right);
            right++;
            
            if(right - left == k) ans[left++] = nums[dq.peekFirst()];
            
            while(!dq.isEmpty() && left > dq.peekFirst()) dq.pollFirst();
            
        }
        return ans;
    }
}