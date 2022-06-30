class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int[] fact = new int[n+1];
        fact[0] = 1;
        for(int i=1; i<=n; i++)
        {
            fact[i] = fact[i-1] *i;
            nums.add(i);
        }
        
        k = k-1;
        
        StringBuilder sb = new StringBuilder();
        while(nums.size() > 0)
        {
            int pick = k/fact[n-1];
            k = k%fact[n-1];
            sb.append(nums.get(pick));
            nums.remove(pick);
            n--;
        }
        return sb.toString();
    }
}