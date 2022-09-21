class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        int preSum = 0;
        Set<Integer> st = new HashSet<>();
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]%2 == 0)
            {
                st.add(i);
                preSum+=nums[i];
            }
        }
        for(int i=0; i<queries.length; i++)
        {
            int val = queries[i][0];
            int index = queries[i][1];
            if(!st.contains(index))
            {
                if((nums[index] + val) % 2 == 0)
                {
                    st.add(index);
                    nums[index]+=val;
                    preSum+=nums[index];
                }
                else
                {
                    nums[index]+=val;
                }
            }
            else
            {
                if((nums[index] + val) % 2 == 0)
                {
                    nums[index]+=val;
                    preSum+=val;
                }
                else
                {
                    preSum-=nums[index];
                    nums[index]+=val;
                    st.remove(index);
                }
            }
            ans[i] = preSum;
        }
        return ans;
    }
}