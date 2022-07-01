class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        
        permutation(nums, 0, output, ans);
        
        return ans;
    }
    public void permutation(int[] nums, int index, List<Integer> output, List<List<Integer>> ans)
    {
        if(output.size() == nums.length)
        {
            ans.add(new ArrayList(output));
            return;
        }
        for(int i=0; i<nums.length; i++)
        {
            if(output.contains(nums[i])) continue;
            
            output.add(nums[i]);
            permutation(nums, 0, output, ans);
            output.remove(output.size()-1);
        }
    }
}