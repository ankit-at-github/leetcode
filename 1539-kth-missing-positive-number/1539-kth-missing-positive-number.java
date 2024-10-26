class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 1, right = 0;
        while(right < arr.length){
            if(arr[right] != left){
                k--;
            }
            else{
                right++;
            }
            left++;
            if(k == 0) return left-1;
        }
        return left+k-1;
    }
}