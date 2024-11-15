class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        
        if(digits.length() == 0) return ans;
        
        Map<Character, String> keypad = new HashMap<>();
        keypad.put('2', "abc");
        keypad.put('3', "def");
        keypad.put('4', "ghi");
        keypad.put('5', "jkl");
        keypad.put('6', "mno");
        keypad.put('7', "pqrs");
        keypad.put('8', "tuv");
        keypad.put('9', "wxyz");
        
        getCombination(0, digits, new StringBuilder(), keypad, ans);
        
        return ans;
    }
    public void getCombination(int index, String digits, StringBuilder sb, Map<Character, String> keypad, List<String> ans){
        if(index >= digits.length()){
            ans.add(sb.toString());
            return;
        }
        String letters = keypad.get(digits.charAt(index));
        for(int i=0; i<letters.length(); i++){
            sb.append(letters.charAt(i));
            getCombination(index+1, digits, sb, keypad, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}