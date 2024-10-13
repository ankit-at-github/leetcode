class Solution {
    public boolean isPalindrome(String s) {
        int p1 = 0, p2 = s.length()-1;
        while(p1 < p2){
            if(Character.isLetterOrDigit(s.charAt(p1)) && Character.isLetterOrDigit(s.charAt(p2))){
                if(Character.toLowerCase(s.charAt(p1)) != Character.toLowerCase(s.charAt(p2))) return false;
                p1++;
                p2--;
            }
            else{
                if(!Character.isLetterOrDigit(s.charAt(p1))) p1++;
                else p2--;
            }
        }
        
        return true;
    }
}