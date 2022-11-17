class Solution {
    public void reverseString(char[] s) {
        //using recursion
        reverse(s, 0, s.length-1);
    }
    public void reverse(char[] s, int start, int end)
    {
        if(s == null || start >= end) return;
        
        swap(s, start, end);
        reverse(s, start+1, end-1);
    }
    public void swap(char[] s, int start, int end)
    {
        char c = s[start];
        s[start] = s[end];
        s[end] = c;
    }
}