class Solution {
    public int maxProduct(String[] words) {
        int ans=0;
        for(int i=0;i<words.length;i++)
        {
            char[] charArray = words[i].toCharArray();
            Arrays.sort(charArray);
            words[i] = String.valueOf(charArray);
        }
        for(int i=0;i<words.length;i++)
        {
            for(int j=i+1;j<words.length;j++)
            {
                int k=0,l=0;
                while(k<words[i].length() && l<words[j].length() && words[i].charAt(k)!=words[j].charAt(l))
                {
                    if(words[i].charAt(k)<words[j].charAt(l))
                        k++;
                    else
                        l++;
                }
                if(k==words[i].length() || l==words[j].length())
                {
                    int x=words[i].length()*words[j].length();
                    ans=Math.max(ans,x);
                }
            }
        }
        return ans;
    }
}