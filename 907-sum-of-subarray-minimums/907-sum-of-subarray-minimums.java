class Solution {
    public int sumSubarrayMins(int[] arr) {
        //One Pass Approach
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        Stack<Integer> mStack = new Stack<>();
        
        //getting count of subarray for PLE(Previous Less Element) for each element in an array
        for(int i=0; i<n; i++)
        {
            while(!mStack.isEmpty() && arr[mStack.peek()] > arr[i])
            {
                mStack.pop();
            }
            left[i] = mStack.isEmpty() ? i+1 : i-mStack.peek();
            mStack.push(i);
        }
        
        mStack.clear();
        
        //getting count of subarray for NLE(Next Less Element) for each element in an array
        for(int i=n-1; i>=0; i--)
        {
            while(!mStack.isEmpty() && arr[mStack.peek()] >= arr[i])
            {
                mStack.pop();
            }
            right[i] = mStack.isEmpty() ? n-i : mStack.peek()-i;
            mStack.push(i);
        }
        
        long sum = 0, modulo = (int)1e9+7;
        for(int i=0; i<n; i++)
        {
            sum=(sum+(long)arr[i]*left[i]*right[i])%modulo;
        }
        
        return (int)sum;
        
    }
}