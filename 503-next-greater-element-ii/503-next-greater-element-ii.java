class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i=nums.length-1; i>=0; i--)
        {
            while(!st.isEmpty() && st.peek() <= nums[i])
            {
                st.pop();
            }
            if(st.isEmpty()) ans[i] = -1;
            else ans[i] = st.peek();
            st.push(nums[i]);
        }
        for(int i=nums.length-1; i>=0; i--)
        {
            while(!st.isEmpty() && st.peek() <= nums[i])
            {
                st.pop();
            }
            if(st.isEmpty()) ans[i] = -1;
            else ans[i] = st.peek();
            st.push(nums[i]);
        }
        
        return ans;
        
    }
}