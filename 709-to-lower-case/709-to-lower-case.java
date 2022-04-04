class Solution {
    public String toLowerCase(String s)
    {
        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<charArray.length; i++)
        {
            char c = charArray[i];
            if(c>='A' && c<='Z') charArray[i]+= 32;
            sb.append(charArray[i]);
        }
        return sb.toString();
    }
}