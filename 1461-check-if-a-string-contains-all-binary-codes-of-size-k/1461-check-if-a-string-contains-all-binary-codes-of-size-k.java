class Solution {
    public boolean hasAllCodes(String s, int k) {
        if(k > s.length()) return false;
        Set<String> subString = new HashSet<>();
        for(int i=0; i<=s.length()-k; i++)
        {
            int index = i;
            int count = k;
            StringBuilder sb = new StringBuilder();
            while(count > 0)
            {
                sb.append(s.charAt(index++));
                count--;
            }
            subString.add(sb.toString());
        }
        if(subString.size() >= Math.pow(2,k)) return true;
        return false;
    }
}