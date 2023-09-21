class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m+n];
        int index = 0;
        int i=0, j=0;
        while(i<m && j<n)
        {
            if(nums1[i] < nums2[j])
            {
                nums[index++] = nums1[i];
                i++;
            }
            else
            {
                nums[index++] = nums2[j];
                j++;
            }
        }
        while(i<m)
        {
            nums[index++] = nums1[i];
            i++;
        }
        while(j<n)
        {
            nums[index++] = nums2[j];
            j++;
        }
        if(index % 2 == 0)
        {
            return (nums[index/2] + nums[index/2-1])/2.0;
        }
        else return nums[index/2];
    }
}