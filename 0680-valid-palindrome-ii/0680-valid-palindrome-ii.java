class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return helper(s, left, right-1) || helper(s, left+1, right);
            }
            left++;
            right--;
        }
        return true;
    }
    public boolean helper(String word, int left, int right){
        while(left < right){
            if(word.charAt(left) != word.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}