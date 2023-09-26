class Solution {
    public String removeDuplicateLetters(String s) {
        //Storing last Index of each character
        int[] lastIndex = new int[26];
        for(int i=0; i<s.length(); i++) lastIndex[s.charAt(i) - 'a'] = i;
        
        boolean[] visited = new boolean[26];
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++)
        {
            if(visited[s.charAt(i) - 'a']) continue;
            
            while(!st.isEmpty() && st.peek() > s.charAt(i) && lastIndex[st.peek() - 'a'] > i)
            {
                visited[st.pop() - 'a'] = false;
            }
            st.push(s.charAt(i));
            visited[s.charAt(i) - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop());
        sb.reverse();
        return sb.toString();
    }
}