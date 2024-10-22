class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Integer, String> keypad = new HashMap<>();
        keypad.put(2, "abc");
        keypad.put(3, "def");
        keypad.put(4, "ghi");
        keypad.put(5, "jkl");
        keypad.put(6, "mno");
        keypad.put(7, "pqrs");
        keypad.put(8, "tuv");
        keypad.put(9, "wxyz");
        
        List<String> ans = new ArrayList<>();
        
        if(digits.length() == 0) return ans;
        
        solve(0, digits, new StringBuilder(), keypad, ans);
        return ans;
    }
    public void solve(int index, String digits, StringBuilder sb, Map<Integer, String> keypad, List<String> ans){
        
        if(sb.length() == digits.length()){
            ans.add(sb.toString());
            return;
        }
        
        String keyPadValue = keypad.get(digits.charAt(index)-'0');
        
        for(int i=0; i<keyPadValue.length(); i++){
            sb.append(keyPadValue.charAt(i));
            solve(index+1, digits, sb, keypad, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}