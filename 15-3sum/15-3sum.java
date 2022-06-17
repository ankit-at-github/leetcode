class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        //At any point if nums[i] > 0 then sum of three elements cant be zero as we check next pair of elements from that index. Since, elements are alreayd sorted then all the elements after that index will be greater than 0.
        for(int i=0; i<nums.length && nums[i]<=0; i++)
        {
            //skip duplicate elemets
            if(i > 0 && nums[i-1]==nums[i]) continue;
            
            twoSumPointer(nums, i, res);
            
        }
        return res;
    }
    public void twoSumPointer(int[] nums, int index, List<List<Integer>> res)
    {
        int i=index+1, j=nums.length-1;
        while(i<j)
        {
            int sum = nums[index] + nums[i] + nums[j];
            if(sum < 0) i++;
            else if(sum > 0) j--;
            else
            {
                res.add(Arrays.asList(nums[index], nums[i], nums[j]));
                i++;j--;
                while(i<j && nums[i]==nums[i-1] && nums[j]==nums[j+1])
                {
                    i++;j--;
                }
            }
        }
    }
}