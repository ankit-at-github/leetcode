class Solution {
    public void reverseString(char[] s) {
        reverse(0, s.length-1, s);
    }
    public void reverse(int start, int end, char[] s)
    {
        if(s == null || start >= end) return;
        
        swap(start, end, s);
        reverse(start+1, end-1, s);
    }
    public void swap(int a, int b, char[] s)
    {
        char temp = s[a];
        s[a] = s[b];
        s[b] = temp;
    }
}