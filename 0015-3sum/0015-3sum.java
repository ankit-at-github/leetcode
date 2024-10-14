class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<=nums.length-3; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            twoSum(i+1, nums, -nums[i], result);
        }
        return result;
    }
    public void twoSum(int start, int[] nums, int target, List<List<Integer>> result){
        int end = nums.length-1;
        while(start < end){
            if(nums[start] + nums[end] > target) end--;
            else if(nums[start] + nums[end] < target) start++;
            else{
                List<Integer> current = new ArrayList<>();
                current.add(-target);
                current.add(nums[start]);
                current.add(nums[end]);
                result.add(current);
                
                while(start < end && nums[start] == nums[start+1]){ start++;}
                
                start++;
                end--;
            }
        }
    }
}