class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1;
        while(m > 0 && n > 0)
        {
            int a = nums1[m-1];
            int b = nums2[n-1];
            
            if(a > b)
            {
                nums1[index--] = a;
                m--;
            }
            else
            {
                nums1[index--] = b;
                n--;
            }
        }
        while(m > 0)
        {
            nums1[index--] = nums1[m-1];
            m--;
        }
        while(n > 0)
        {
            nums1[index--] = nums2[n-1];
            n--;
        }
    }
}