class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        
        if(digits.length() == 0) return ans;
        
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        StringBuilder output = new StringBuilder();
        
        solve(digits, 0, output, ans, map);
        
        return ans;
    }
    public void solve(String digits, int index, StringBuilder output, List<String> ans, Map<Character, String> m)
    {
        if(index >= digits.length())
        {
            ans.add(output.toString());
            return;
        }
        
        String value = m.get(digits.charAt(index));
        
        for(int i=0; i<value.length(); i++)
        {
            output.append(value.charAt(i));
            solve(digits, index+1, output, ans, m);
            output.deleteCharAt(output.length()-1);
        }
    }
}