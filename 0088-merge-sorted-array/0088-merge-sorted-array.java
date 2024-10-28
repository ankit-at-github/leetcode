class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1, p2 = n-1;
        int index = nums1.length-1;
        while(p1 >= 0 && p2 >= 0){
            if(nums1[p1] > nums2[p2]){
                nums1[index] = nums1[p1];
                p1--;
            }
            else{
                nums1[index] = nums2[p2];
                p2--;
            }
            index--;
        }
        while(p1>=0){
            nums1[index] = nums1[p1];
            p1--;
            index--;
        }
        while(p2>=0){
            nums1[index] = nums2[p2];
            p2--;
            index--;
        }
    }
}