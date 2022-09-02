class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];
        
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<heights.length; i++)
        {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            if(st.isEmpty()) leftSmaller[i] = -1;
            else leftSmaller[i] = st.peek();
            st.add(i);
        }
        st.clear();
        for(int i=heights.length-1; i>=0; i--)
        {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            if(st.isEmpty()) rightSmaller[i] = n;
            else rightSmaller[i] = st.peek();
            st.add(i);
        }
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) maxi = Math.max(maxi, (rightSmaller[i]-leftSmaller[i]-1)*heights[i]);
        return maxi;
    }
}