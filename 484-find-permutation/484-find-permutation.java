class Solution {
    public int[] findPermutation(String s) {
        List<Integer> l = new ArrayList<>();
        for(int i=0; i<=s.length(); ++i)
        {
            if(i == s.length() || s.charAt(i) == 'I')
            {
                int rLen = l.size();
                for(int countD=i-rLen+1; countD>0; --countD) l.add(rLen + countD);
            }
        }
        int[] ans = new int[l.size()];
        for(int i=0; i<l.size(); i++) ans[i] = l.get(i);
        
        return ans;
    }
}  