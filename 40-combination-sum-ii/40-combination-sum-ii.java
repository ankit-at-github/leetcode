class Solution {
    public void solve(int[] c, int index, List<Integer> temp, List<List<Integer>> ans, int target)
    {
        if(target==0)
        {
            ans.add(new ArrayList(temp));
        }
        
        for(int i=index; i<c.length; i++)
        {
            if(i>index && c[i]==c[i-1]) continue; //to avoid duplicate addition
            if(target<c[i]) break;
                
            temp.add(c[i]);
            solve(c, i+1, temp, ans, target-c[i]);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, 0, new ArrayList<>(), ans, target);
        
        return ans;
    }
}