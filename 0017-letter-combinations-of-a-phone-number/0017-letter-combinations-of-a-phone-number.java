class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> keypad = new HashMap<>();
        keypad.put('2', "abc");
        keypad.put('3', "def");
        keypad.put('4', "ghi");
        keypad.put('5', "jkl");
        keypad.put('6', "mno");
        keypad.put('7', "pqrs");
        keypad.put('8', "tuv");
        keypad.put('9', "wxyz");
        
        List<String> ans = new ArrayList<>();
        
        if(digits.length() == 0) return ans;
        
        solve(digits, 0, new StringBuilder(), ans, keypad);
        
        return ans;
    }
    public void solve(String digits, int index, StringBuilder sb, List<String> ans, Map<Character, String> keypad){
        if(index >= digits.length()){
            ans.add(new String(sb.toString()));
            return;
        }
        
        String letters = keypad.get(digits.charAt(index));
        
        //System.out.println(letters);
        
        for(int i=0; i<letters.length(); i++){
            sb.append(letters.charAt(i));
            solve(digits, index+1, sb, ans, keypad);
            sb.deleteCharAt((sb.length()-1));
        }
    }
}