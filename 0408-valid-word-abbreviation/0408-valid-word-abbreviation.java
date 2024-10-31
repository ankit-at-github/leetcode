class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int p1=0, p2=0;
        int num = 0;
        while(p2 < abbr.length()){
            char c = abbr.charAt(p2);
            if(Character.isDigit(c)){
                num = num * 10 + c-'0';
                if(num == 0) return false;
            }
            else{
                p1+=num;
                num = 0;
                
                if(p1 >= word.length() || c != word.charAt(p1)) return false;
                
                p1++;
                
            }
            p2++;
        }
        
        return p1+num == word.length();
    }
}