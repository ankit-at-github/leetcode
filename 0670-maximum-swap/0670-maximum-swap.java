class Solution {
    public int maximumSwap(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int n = nums.length;
        int[] max_Index = new int[n];
        int maxi = n-1;
        
        for(int i=n-1; i>=0; i--){
            if(nums[i] <= nums[maxi]){
                max_Index[i] = maxi;
            }
            else{
                max_Index[i] = i;
                maxi = i;
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] != nums[max_Index[i]]){
                char temp = nums[i];
                nums[i] = nums[max_Index[i]];
                nums[max_Index[i]] = temp;
                return Integer.parseInt(new String(nums));
            }
        }
        return num;
    }
}