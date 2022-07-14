class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[nums.length-k+1];
        int left = 0, right = 0;
        while(right < nums.length)
        {
            //remove index if it is outside of range K
            while(!dq.isEmpty() && dq.peekFirst() < (right - k +1)) dq.pollFirst();
            
            while(!dq.isEmpty() && nums[right] > nums[dq.peekLast()]) dq.pollLast();
            
            dq.addLast(right);
            
            if(right-left+1 == k) ans[left++] = nums[dq.peekFirst()];
            
            right++;
        }
        return ans;
    }
}