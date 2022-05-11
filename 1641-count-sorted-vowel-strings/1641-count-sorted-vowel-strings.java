class Solution {
    public int countVowelStrings(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder output = new StringBuilder();
        String vowels = "aeiou";
        solve(vowels, n, output, ans);
        return ans.size();
    }
    public void solve(String vowels, int n, StringBuilder output, List<String> ans)
    {
        if(n == 0)
        {
            ans.add(output.toString());
            return;
        }
        for(int i=0; i<vowels.length(); i++)
        {
            if(output.length() >= 1 && vowels.charAt(i) < output.charAt(output.length()-1)) continue;
            output.append(vowels.charAt(i));
            solve(vowels, n-1, output, ans);
            output.deleteCharAt(output.length()-1);
        }
    }
}