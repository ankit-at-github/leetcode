class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String word : words)
        {
            StringBuilder rev = new StringBuilder(word);
            rev.reverse();
            sb.append(rev+" ");
        }
        return sb.toString().trim();
    }
}