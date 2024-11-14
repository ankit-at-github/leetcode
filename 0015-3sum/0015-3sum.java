class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            
            if(i > 0 && nums[i] == nums[i-1]) continue;
            twoSum(i, nums, ans);
        }
        return ans;
    }
    public void twoSum(int i, int[] nums, List<List<Integer>> ans){
        int j = i+1;
        int k = nums.length-1;
        
        while(j < k){
            if(nums[j] + nums[k] == -nums[i]){
                ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                j++;
                k--;
                while(j < k && nums[j] == nums[j-1]) j++;
            }
            else if(nums[j] + nums[k] < -nums[i]){
                j++;
            }
            else{
                k--;
            }
        }
    }
}