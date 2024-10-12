class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        if(n == 1) return new int[]{0};
        List<Integer> ans = new ArrayList<>();
        int previousHeight = heights[n-1];
        ans.add(0, n-1);
        for(int i=heights.length-2; i>=0; i--){
            
            if(heights[i] > previousHeight){
                previousHeight = heights[i];
                ans.add(0, i);
            }
        }
        int[] result = new int[ans.size()];
        int index = 0;
        for(int i : ans) result[index++] = i;
        return result;
    }
}