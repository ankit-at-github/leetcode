class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for(int i=0; i<l.length; i++)
        {
            ans.add(check(l[i], r[i], nums));
        }
        return ans;
    }
    public boolean check(int start, int end, int[] nums)
    {
        int[] part = new int[end-start+1];
        int index = 0;
        while(start<=end) part[index++] = nums[start++];
        Arrays.sort(part);
        int diff = part[1]-part[0];
        for(int i=2; i<part.length; i++)
        {
            if((part[i] - part[i-1])!=diff) return false;
        }
        return true;
    }
}