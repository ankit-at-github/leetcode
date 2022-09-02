class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        
        int[] leftSmallest = new int[n];
        int[] rightSmallest = new int[n];
        Stack<Integer> st = new Stack<>();
        //getting leftSmallest
        for(int i=0; i<n; i++)
        {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            if(st.isEmpty()) leftSmallest[i] = -1;
            else leftSmallest[i] = st.peek();
            st.add(i);
        }
        st.clear();
        //getting rightSmallest
        for(int i=n-1; i>=0; i--)
        {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            if(st.isEmpty()) rightSmallest[i] = n;
            else rightSmallest[i] = st.peek();
            st.add(i);
        }
        int maxi = Integer.MIN_VALUE;
        //getting area
        for(int i=0; i<n; i++) maxi = Math.max(maxi, (rightSmallest[i]-leftSmallest[i]-1)*heights[i]);
        return maxi;
    }
}