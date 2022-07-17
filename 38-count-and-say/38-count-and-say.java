class Solution {
    public String countAndSay(int n) {
        StringBuilder res = new StringBuilder("1");
        for(int i=1; i<n; i++)
        {
            StringBuilder current = new StringBuilder();
            for(int j=0; j<res.length(); j++)
            {
                int count = 1;
                while(j < res.length()-1 && res.charAt(j) == res.charAt(j+1))
                {
                    count++;
                    j++;
                }
                current.append(count).append(res.charAt(j));
            }
            res = current;
        }
        return res.toString();
    }
}