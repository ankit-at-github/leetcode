class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> st = new HashSet<>();
        for(String word : words)
        {
            char[] charArray = word.toCharArray();
            StringBuilder sb = new StringBuilder();
            for(char c : charArray) sb.append(morse[c-'a']);
            st.add(sb.toString());
        }
        return st.size();
    }
}