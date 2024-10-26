class Solution {
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length-1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            //Expected element at mid is mid+1.
            int no_of_missing_elements = arr[mid] - (mid+1);
            if(no_of_missing_elements < k) left = mid+1;
            else right = mid-1;
        }
        //arr[right] is arr[right] - right - 1. Hence, the number to return is arr[right] + k - (arr[right] - right - 1) = k + left.
        
        return k + left;
    }
}