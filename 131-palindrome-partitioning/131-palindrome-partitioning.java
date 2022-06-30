class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> output = new ArrayList<>();
        partition(s, 0, output, ans);
        return ans;
    }
    public boolean isPalindrome(String s, int start, int end)
    {
        while(start < end)
        {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
    public void partition(String s, int index, List<String> output, List<List<String>> ans)
    {
        if(index == s.length())
        {
            ans.add(new ArrayList(output));
        }
        
        for(int i=index; i<s.length(); i++)
        {
            if(isPalindrome(s, index, i))
            {
                output.add(s.substring(index, i+1));
                partition(s, i+1, output, ans);
                output.remove(output.size()-1);
            }
        }
    }
}