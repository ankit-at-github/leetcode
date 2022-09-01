class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        int left = 0, right = 0;
        Deque<Integer> dq = new LinkedList<>();
        while(right < nums.length)
        {
            while(!dq.isEmpty() && nums[right] > nums[dq.peekLast()]) dq.pollLast();
            
            dq.add(right);
            
            if(right - left+1 == k) ans[left++] = nums[dq.peekFirst()];
            
            while(!dq.isEmpty() && left > dq.peekFirst()) dq.pollFirst();
            
            right++;
        }
        return ans;
    }
}