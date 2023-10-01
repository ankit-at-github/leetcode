class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int start = 0, lastSpaceIndex = 0;
        for(int i=0; i<s.length(); i++)
        {
            if(Character.isWhitespace(s.charAt(i)))
            {
                lastSpaceIndex = i;
                sb.append(reverse(start,lastSpaceIndex-1, s));
                sb.append(" ");
                start = lastSpaceIndex+1;
            }
        }
        sb.append(reverse(start, s.length()-1, s));
        return sb.toString();
    }
    public String reverse(int left, int right, String word)
    {
        StringBuilder sb = new StringBuilder();
        for(int i=right; i>=left; i--) sb.append(word.charAt(i));
        return sb.toString();
    }
}