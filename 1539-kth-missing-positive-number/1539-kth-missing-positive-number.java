class Solution {
    public int findKthPositive(int[] arr, int k) {
        if(arr[0] != 1){
            if(arr[0] - 1 >= k) return k;
            else{
                k-=arr[0]-1;
            }
        }
        int i = 0;
        while(i < arr.length-1){
            int diff = arr[i] - arr[i+1];
            if(diff != 1){
                for(int num=arr[i]+1; num<arr[i+1]; num++){
                    k--;
                    if(k == 0) return num;
                }
            }
            i++;
        }
        return arr[arr.length-1] + k;
    }
}