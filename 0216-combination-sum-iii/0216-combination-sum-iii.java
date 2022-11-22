class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        
        solve(1, k, n, output, ans);
        
        return ans;
    }
    public void solve(int start, int k, int n, List<Integer> output, List<List<Integer>> ans)
    {
        if(n == 0 && output.size() == k)
        {
            ans.add(new ArrayList(output));
            return;
        }
        
        for(int i=start; i<=9; i++)
        {
            if(n-i < 0) break;
            
            output.add(i);
            solve(i+1, k, n-i, output, ans);
            output.remove(output.size()-1);
        }
    }
}