class Solution {
    public int maximum69Number (int num) {
        String n = Integer.toString(num);
        char[] charArray = n.toCharArray();
        
        for(int i=0; i<charArray.length; i++)
        {
            if(charArray[i] == '6')
            {
                charArray[i] = '9';
                break;
            }
        }
        num = Integer.parseInt(String.valueOf(charArray));
        return num;
    }
}