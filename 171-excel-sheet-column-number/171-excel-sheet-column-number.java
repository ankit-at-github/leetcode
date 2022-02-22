class Solution {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        int len = columnTitle.length()-1;
        for(int i=0; i<columnTitle.length(); i++)
        {
            ans+= Math.pow(26,len)*(columnTitle.charAt(i)-64);
            len--;
        }
        return ans;
    }
}