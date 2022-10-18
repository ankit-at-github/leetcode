class Solution {
    public String countAndSay(int n) {
        StringBuilder start = new StringBuilder("1");
        
        if(n==1) return start.toString();
        
        for(int i=2; i<=n; i++)
        {
            int count = 1;
            StringBuilder temp = new StringBuilder();
            for(int j=1; j<start.length(); j++)
            {
                if(start.charAt(j) == start.charAt(j-1)) count++;
                else
                {
                    temp.append(Integer.toString(count)).append(start.charAt(j-1));
                    count = 1;
                }
            }
            temp.append(Integer.toString(count)).append(start.charAt(start.length()-1));
            start = temp;
        }
        return start.toString();
    }
}