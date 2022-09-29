class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) map.put(s.charAt(i), i);
        
        List<Integer> ans = new ArrayList<>();
        int lastIndex = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++)
        {
            if(map.get(s.charAt(i)) <= lastIndex) sb.append(s.charAt(i));
            else
            {
                lastIndex = Math.max(lastIndex, map.get(s.charAt(i)));
                sb.append(s.charAt(i));
            }
            
            if(lastIndex == i)
            {
                //System.out.println(sb.toString());
                ans.add(sb.length());
                sb.delete(0, sb.length());
            }
            
        }
        return ans;
    }
}