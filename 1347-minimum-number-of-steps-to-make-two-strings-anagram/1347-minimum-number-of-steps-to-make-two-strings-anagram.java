class Solution {
    public static int a = 97;
    public int minSteps(String s, String t) {
        int[] freq = new int[26];
        char[] charArray1 = s.toCharArray();
        char[] charArray2 = t.toCharArray();
        for(int i=0; i<s.length(); i++)
        {
            freq[charArray1[i] - a]++;
            freq[charArray2[i] - a]--;
        }
        
        int count = 0;
        for(int x : freq) if(x>0) count+=x;
        return count;
    }
}