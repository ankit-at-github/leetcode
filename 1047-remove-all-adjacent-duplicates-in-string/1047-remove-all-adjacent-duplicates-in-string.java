class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(st.isEmpty()) st.push(c);
            else{
                if(st.peek() == c) st.pop();
                else st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Character c : st){
            sb.append(c);
        }
        return sb.toString();
    }
}