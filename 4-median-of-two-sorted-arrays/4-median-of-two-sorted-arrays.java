class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N = (nums1.length + nums2.length);
        int count = 0;
        int p1=0, p2=0, med1=0, med2=0;
        while(p1<nums1.length && p2<nums2.length)
        {
            med2 = med1;
            
            if(nums1[p1] < nums2[p2]) med1 = nums1[p1++];
            else med1 = nums2[p2++];
            
            count++;
            
            if(count == (N/2)+1) break;
        }
        while(p1<nums1.length && count!=(N/2)+1)
        {
            med2 = med1;
            med1 = nums1[p1++];
            count++;
        }
        while(p2<nums2.length && count!=(N/2)+1)
        {
            med2 = med1;
            med1 = nums2[p2++];
            count++;
        }
        
        if(N%2==0)
        {
            double median = (med1+med2)/2.0;
            return median;
        }
        
        return (double)med1;
    }
}