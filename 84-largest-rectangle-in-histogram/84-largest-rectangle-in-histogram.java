class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Pair> ns = new Stack<>();
        
        int[] left = new int[n];
        int[] right = new int[n];
        
        for(int i=0; i<n; i++)
        {
            while(!ns.isEmpty() && ns.peek().height >= heights[i]) ns.pop();
            if(ns.isEmpty()) left[i] = -1;
            else left[i] = ns.peek().index;
            ns.push(new Pair(heights[i], i));
        }
        
        ns.clear();
        
        for(int i=n-1; i>=0; i--)
        {
            while(!ns.isEmpty() && ns.peek().height >= heights[i]) ns.pop();
            if(ns.isEmpty()) right[i] = n;
            else right[i] = ns.peek().index;
            ns.push(new Pair(heights[i], i));
        }
        
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<n; i++)
        {
            int width = (right[i]-left[i]-1);
            maxi = Math.max(maxi, width*heights[i]);
        }
        
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