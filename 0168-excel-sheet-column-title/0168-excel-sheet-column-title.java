class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0)
        {
            int remainder = columnNumber%26;
            
            if(remainder == 0)
            {
                sb.append("Z");
                columnNumber = columnNumber/26 - 1;
            }
            else
            {
                sb.append(Character.toString((char) (remainder + 64)));
                columnNumber = columnNumber/26;
            }
        }
        return sb.reverse().toString();
    }
}