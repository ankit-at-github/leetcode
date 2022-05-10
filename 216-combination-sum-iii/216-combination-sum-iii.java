class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int start = 1;
        solve(start, k, n, result, ans);
        return ans;
    }
    public void solve(int start, int k, int n, List<Integer> result, List<List<Integer>> ans)
    {
        if(n == 0 && result.size() == k)
        {
            ans.add(new ArrayList(result));
            return;
        }
        for(int i=start; i<=9; i++)
        {
            if(n-i < 0) break;
            result.add(i);
            solve(i+1, k, n-i, result, ans);
            result.remove(result.size()-1);
        }
    }
}