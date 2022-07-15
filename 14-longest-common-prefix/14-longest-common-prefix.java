class Solution {
    public String longestCommonPrefix(String[] strs) {
        Map<Integer, Character> indexMap = new HashMap<>();
        for(int i=0; i<strs[0].length(); i++) indexMap.put(i, strs[0].charAt(i));
        
        int count;
        int mini = Integer.MAX_VALUE;
        for(String s : strs)
        {
            count = 0;
            for(int i=0; i<Math.min(s.length(), indexMap.size()); i++)
            {
                if(s.charAt(i) == indexMap.get(i)) count++;
                else break;
            }
            mini = Math.min(mini, count);
        }
        if(mini == 0) return "";
        return strs[0].substring(0, mini);
    }
}