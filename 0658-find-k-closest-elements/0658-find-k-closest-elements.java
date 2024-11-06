class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = getIndex(arr, x);
        
        int left = index-1, right = left+1;
        
        while(right - left - 1 < k){
            //element found at 0th index
            if(left == -1){
                right++;
                continue;
            }
            //element found at last index or somewhere in mid
            if(right == arr.length || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)){
                left--;
            }
            else{
                right++;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i = left+1; i < right; i++){
            ans.add(arr[i]);
        }
        return ans;
    }
    public int getIndex(int[] arr, int x){
        int low = 0, high = arr.length;
        while(low < high){
            int mid = low + (high - low) / 2;
            
            if(arr[mid] < x) low = mid+1;
            else high = mid;
        }
        return low;
    }
}