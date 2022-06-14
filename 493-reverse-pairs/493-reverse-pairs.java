class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    public int mergeSort(int[] nums, int start, int end)
    {
        int count = 0;
        if(start < end)
        {
            int mid = start + (end-start)/2;
            count+=mergeSort(nums, start, mid);
            count+=mergeSort(nums, mid+1, end);
            count+=merge(nums, start, mid, end);
        }
        return count;
    }
    public int merge(int[] nums, int start, int mid, int end)
    {
        //getting the count
        int i=start, j=mid+1;
        int count = 0;
        while(i<=mid)
        {
            while(j <= end && nums[i] > (2*(long)nums[j]))j++;
            int steps = j-(mid+1);
            count+=steps;
            i++;
        }
        
        //performing merge using extra temp array
        ArrayList<Integer> temp = new ArrayList<>();
        int left = start, right = mid+1;
        while(left<=mid && right<=end)
        {
            if(nums[left] <= nums[right]) temp.add(nums[left++]);
            else temp.add(nums[right++]);
        }
        while(left<=mid) temp.add(nums[left++]);
        while(right<=end) temp.add(nums[right++]);
        
        for(int k=start; k<=end; k++) nums[k] = temp.get(k-start);
        
        return count;
    }
}