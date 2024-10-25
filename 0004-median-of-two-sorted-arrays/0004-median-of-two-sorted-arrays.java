class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int p1=0, p2=0;
        int count = 0, m1 = 0, m2 = 0;
        while(count <= total / 2){
            m2 = m1;
            if(p1 != nums1.length && p2 != nums2.length){
                if(nums1[p1] < nums2[p2]){
                    m1 = nums1[p1++];
                }
                else{
                    m1 = nums2[p2++];
                }
            }
            else{
                if(p1 < nums1.length){
                m1 = nums1[p1++];
                }
                if(p2 < nums2.length){
                    m1 = nums2[p2++];
                }
            }
            count++;
        }
        if(total % 2 != 0) return m1;
        else return (m1 + m2)/2.0;
    }
}