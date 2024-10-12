class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        if(n == 1) return new int[]{0};
        List<Integer> ans = new ArrayList<>();
        int previousHeight = heights[n-1];
        ans.add(n-1);
        for(int i=heights.length-2; i>=0; i--){
            
            if(heights[i] > previousHeight){
                previousHeight = heights[i];
                ans.add(i);
            }
        }
        int[] result = new int[ans.size()];
        int index = 0;
        for(int i=ans.size()-1; i>=0; i--) result[index++] = ans.get(i);
        return result;
    }
}