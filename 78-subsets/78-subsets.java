class Solution {
    public void solve(int[] arr, int index, List<Integer> l, List<List<Integer>> result)
    {
        result.add(new ArrayList(l));
        
        for(int j=index; j<arr.length; j++)
        {
            l.add(arr[j]);
            solve(arr, j+1, l, result);
            l.remove(l.size()-1);
        }
        
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        
        
        solve(nums, 0, output, ans);
        
        return ans;
        
    }
}