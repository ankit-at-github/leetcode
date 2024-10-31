class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        //brute force
        List<List<Integer>> result = new ArrayList<>();
        int expected = lower;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != expected){
                result.add(Arrays.asList(expected, nums[i]-1));
                expected = nums[i]+1;
            }
            else{
                expected++;
            }
        }
        if(expected <= upper) result.add(Arrays.asList(expected, upper));
        return result;
    }
}