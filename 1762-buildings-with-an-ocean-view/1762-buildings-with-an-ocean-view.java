class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        if(n == 1) return new int[]{0};
        Stack<Integer> buildings = new Stack<>();
        buildings.push(n-1);
        for(int i=heights.length-2; i>=0; i--){
            if(heights[i] > heights[buildings.peek()]){
                buildings.push(i);
            }
        }
        int[] ans = new int[buildings.size()];
        int index = 0;
        while(!buildings.isEmpty()){
            ans[index++] = buildings.pop();
        }
        return ans;
    }
}