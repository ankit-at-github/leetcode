class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];
        
        for(int[] update : updates)
        {
            int start = update[0];
            int end = update[1];
            int value = update[2];
            
            arr[start]+= value;
            
            if(end+1 < length)
                arr[end+1]+= -value;
        }
        
        for(int i=1; i<length; i++)
            arr[i]+=arr[i-1];
        
        return arr;
    }
}