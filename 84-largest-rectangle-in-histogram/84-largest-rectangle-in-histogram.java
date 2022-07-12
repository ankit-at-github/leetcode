class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Pair> nsr = new Stack<>();
        Stack<Pair> nsl = new Stack<>();
        
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i=0; i<n; i++)
        {
            while(!nsl.isEmpty() && nsl.peek().height >= heights[i]) nsl.pop();
            if(nsl.isEmpty()) left[i] = -1;
            else left[i] = nsl.peek().index;
            nsl.push(new Pair(heights[i], i));
        }
        
        for(int i=n-1; i>=0; i--)
        {
            while(!nsr.isEmpty() && nsr.peek().height >= heights[i]) nsr.pop();
            if(nsr.isEmpty()) right[i] = n;
            else right[i] = nsr.peek().index;
            nsr.push(new Pair(heights[i], i));
        }
        
        int[] width = new int[n];
        for(int i=0; i<n; i++) width[i] = right[i]-left[i]-1;
        
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) maxi = Math.max(maxi, width[i] * heights[i]);
        
        return maxi;
        
    }
}
class Pair{
    int height;
    int index;
    Pair(int h, int i)
    {
        height = h;
        index = i;
    }
}