class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N = nums1.length + nums2.length;
        int[] temp = new int[N];
        int k = N-1;
        int p1 = nums1.length-1, p2 = nums2.length-1;
        while(p1 >= 0 && p2 >= 0)
        {
            if(nums1[p1] >= nums2[p2])
                temp[k--] = nums1[p1--];
            else
                temp[k--] = nums2[p2--];
        }
        while(p1>=0) temp[k--] = nums1[p1--];
        while(p2>=0) temp[k--] = nums2[p2--];
        
        if(N%2==0)
        {
            double median = (temp[(N/2)-1] + temp[N/2])/2.0;
            return median;
        }
        
        return (double)temp[N/2];
        
    }
}