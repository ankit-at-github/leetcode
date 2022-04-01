class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for(int start=0; start<arr.length; start++)
        {
            for(int end=start; end<arr.length; end+=2)
            {
                for(int i=start; i<=end; i++)
                {
                    sum+=arr[i];
                }
            }
        }
        return sum;
    }
}