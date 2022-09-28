class Solution {
    public boolean isPalindrome(String s) {
        s = s.trim();
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++)
        {
            if(Character.isLetterOrDigit(s.charAt(i))) sb.append(s.charAt(i));
        }
        String reverse = sb.toString();
        sb.reverse();
        return reverse.equals(sb.toString());
    }
}