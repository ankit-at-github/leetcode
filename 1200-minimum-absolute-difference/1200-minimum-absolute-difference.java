class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int mini = Integer.MAX_VALUE;
        for(int i=0; i<arr.length-1; i++)
        {
            int diff = Math.abs(arr[i] - arr[i+1]);
            if(diff == mini)
            {
                ans.add(Arrays.asList(arr[i], arr[i+1]));
            }
            else if(diff < mini)
            {
                mini = diff;
                ans.clear();
                ans.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }
        return ans;
    }
}