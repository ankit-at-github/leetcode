class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c) || Character.isLetter(c))
            {
                sb.append(Character.toLowerCase(c));
            }
        }
        int left = 0, right = sb.length()-1;
        while(left < right )
        {
            if(sb.charAt(left) != sb.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}