class Solution {
    public boolean isStrobogrammatic(String num) {
        char[] nums = num.toCharArray();
        int left = 0, right = nums.length-1;
        while(left <= right){
            if(nums[left] == '0' && nums[right] == '0'){
                left++;
                right--;
            }else if(nums[left] == '1' && nums[right] == '1'){
                left++;
                right--;
            }else if(nums[left] == '8' && nums[right] == '8'){
                left++;
                right--;
            }else if(nums[left] == '6' && nums[right] == '9'){
                left++;
                right--;
            }else if(nums[left] == '9' && nums[right] == '6'){
                left++;
                right--;
            }
            else return false;
        }
        return true;
    }
}