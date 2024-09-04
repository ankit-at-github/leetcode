class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m-1, right = n-1;
        int index = m+n-1;
        while(left >= 0 && right >= 0){
            if(nums1[left] >= nums2[right]){
                nums1[index] = nums1[left];
                index--;
                left--;
            }
            else{
                nums1[index] = nums2[right];
                index--;
                right--;
            }
        }
        while(left>=0){
            nums1[index] = nums1[left];
            index--;
            left--;
        }
        while(right>=0){
            nums1[index] = nums2[right];
            index--;
            right--;
        }
    }
}