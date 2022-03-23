class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];
        
        for(int[] update : updates)
        {
            int start = update[0];
            int end = update[1];
            int value = update[2];
            for(int i=start; i<=end; i++)
            {
                arr[i]+=value;
            }
        }
        return arr;
    }
}