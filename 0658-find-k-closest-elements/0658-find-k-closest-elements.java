class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //if startIndex(left) is 0, then maximum endIndex(right) to accomodate all k elements will be arr.length-k 
        int left = 0, right = arr.length - k;
        
        while(left < right){
            //midpoint is on left side
            int mid = left + (right - left) / 2;
            
            if(x - arr[mid] > arr[mid+k] - x){
                left = mid+1;
            }
            else right = mid;
        }
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i = left; i < left + k; i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}