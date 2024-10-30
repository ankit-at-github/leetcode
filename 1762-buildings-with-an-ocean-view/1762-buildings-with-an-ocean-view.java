class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        List<Integer> ans = new ArrayList<>();
        ans.add(n-1);
        int maxi = heights[n-1];
        for(int right=n-2; right>=0; right--){
            if(heights[right] > maxi){
                maxi = Math.max(maxi, heights[right]);
                ans.add(right);
            }
        }
        int[] result = new int[ans.size()];
        int index = 0;
        for(int i=ans.size()-1; i>=0; i--){
            result[index++] = ans.get(i);
        }
        return result;
    }
}