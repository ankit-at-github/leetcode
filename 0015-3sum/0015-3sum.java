class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<nums.length; i++)
        {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            
            twoPointer(i, nums, ans);
        }
        return ans;
    }
    public void twoPointer(int index, int[] nums, List<List<Integer>> ans)
    {
        int left = index+1, right = nums.length-1;
        while(left < right)
        {
            if(nums[index] + nums[left] + nums[right] > 0) right--;
            else if(nums[index] + nums[left] + nums[right] < 0) left++;
            else
            {
                ans.add(Arrays.asList(nums[index], nums[left], nums[right]));
                left++;right--;
                while(left < right && nums[left] == nums[left-1]) left++;
                //while(right > left && nums[right] == nums[right+1]) right--;
            }
        }
    }
}