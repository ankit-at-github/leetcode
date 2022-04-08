class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        int[] counter1 = new int[101];
        int[] counter2 = new int[101];
        
        for(int i=0; i<nums1.length; i++)
        {
            counter1[nums1[i]]++;
            counter2[nums2[i]]++;
        }
        
        int p1 = 1, p2 = 100;
        int sum = 0;
        while(p1<=100 && p2>=1)
        {
            if(counter1[p1]!=0 && counter2[p2]!=0)
            {
                int times = Math.min(counter1[p1], counter2[p2]);
                sum+= times*(p1*p2);
                counter1[p1]-=times;
                counter2[p2]-=times;
            }
            else if(counter1[p1] == 0) p1++;
            else p2--;
        }
        
        return sum;
        
    }
}