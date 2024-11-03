class Solution {
    public int[] productExceptSelf(int[] nums) {
        //nums : 1,2,3,4
        //prefix: 1,1,2,6
        //postfix: 24,12,4,1
        int[] output = new int[nums.length];
        output[0] = 1;
        for(int i=1; i<nums.length; i++){
            output[i] = output[i-1] * nums[i-1];
        }
        int postfix = 1;
        for(int i=nums.length-1; i>=0; i--){
            output[i] = output[i]*postfix;
            postfix = postfix * nums[i];
        }
        return output;
    }
}