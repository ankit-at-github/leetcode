class Solution {
    public String removeDuplicateLetters(String s) {
        if(s.length() == 0) return "";
        
        //getting lastIndex of each character in the string
        int[] lastIndex = new int [26];
        for(int i=0; i<s.length(); i++)
        {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        Stack<Character> st = new Stack<>();
        boolean[] visited = new boolean[26];
        st.push(s.charAt(0));
        visited[s.charAt(0) - 'a'] = true;
        
        for(int i=1; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            while(!st.isEmpty() && ch < st.peek() && lastIndex[st.peek()-'a'] > i && !visited[ch-'a'])
            {
                visited[st.peek()-'a'] = false;
                st.pop();
            }
            
            if(!visited[ch-'a'])
            {
                st.push(ch);
                visited[ch-'a'] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        
        while(st.size() > 0)
        {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}