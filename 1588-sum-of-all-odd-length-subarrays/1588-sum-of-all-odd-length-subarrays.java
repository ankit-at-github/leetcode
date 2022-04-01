class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for(int i=1; i<=arr.length; i+=2)
        {
            for(int start = 0; start<=arr.length-i; start++)
            {
                for(int end = start; end<start+i; end++)
                    sum+=arr[end];
            }
        }
        return sum;
    }
}