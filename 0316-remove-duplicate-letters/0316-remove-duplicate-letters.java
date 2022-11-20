class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray()) freq[ch-'a']++;
        
        Stack<Character> st = new Stack<>();
        boolean[] visited = new boolean[26];
        
        for(int i=0; i<s.length(); i++)
        {
            freq[s.charAt(i)-'a']--;
            
            if(!visited[s.charAt(i)-'a'])
            {
                while(!st.isEmpty() && s.charAt(i) < st.peek() && freq[st.peek()-'a'] > 0)
                {
                    visited[st.pop()-'a'] = false;
                }
                st.push(s.charAt(i));
                visited[s.charAt(i)-'a'] = true;
            }
        }
        
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()) ans.append(st.pop());
        return ans.reverse().toString();
    }
}