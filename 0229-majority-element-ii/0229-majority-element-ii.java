class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int majority1 = Integer.MIN_VALUE, majority2 = Integer.MIN_VALUE;
        int count1 = 0, count2 = 0;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] == majority1) count1++;
            else if(nums[i] == majority2) count2++;
            else if(count1 == 0)
            {
                majority1 = nums[i];
                count1 = 1;
            }
            else if(count2 == 0)
            {
                majority2 = nums[i];
                count2 = 1;
            }
            else
            {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int x : nums)
        {
            if(x == majority1) count1++;
            if(x == majority2) count2++;
        }
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        if(count1 > n/3) ans.add(majority1);
        if(count2 > n/3) ans.add(majority2);
        return ans;
    }
}