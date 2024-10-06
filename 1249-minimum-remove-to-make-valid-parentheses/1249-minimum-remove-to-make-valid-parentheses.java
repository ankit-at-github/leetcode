class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        int counter = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(i);
                counter++;
            }
            else if(s.charAt(i) == ')'){
                if(counter == 0) st.push(i);
                else{
                    st.pop();
                    counter--;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i=s.length()-1; i >= 0; i--){
            if(!st.isEmpty() && st.peek() == i) st.pop();
            else result.append(s.charAt(i));
        }
        return result.reverse().toString();
    }
}