class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        
        int[] lastIndex = new int[26];
        for(int i=0; i<s.length(); i++) lastIndex[s.charAt(i)-'a'] = i;
        
        int end = 0, lastValue = 0;
        for(int i=0; i<s.length(); i++)
        {
            end = Math.max(end, lastIndex[s.charAt(i)-'a']);
            
            if(i == end)
            {
                ans.add(end - lastValue+1);
                lastValue = i+1;
            }
        }
        return ans;
    }
}