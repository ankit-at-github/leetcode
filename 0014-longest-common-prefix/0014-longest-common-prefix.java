class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        int mini = Integer.MAX_VALUE;
        Map<Integer, Character> map = new HashMap<>();
        int i=0;
        while(i < strs.length){
            int prefixLength = 0;
            String str = strs[i];
            for(int j=0; j<str.length(); j++){
                if(!map.containsKey(j)){
                    map.put(j, str.charAt(j));
                }
                else{
                    if(str.charAt(j) != map.get(j)) break;
                    else prefixLength++;
                }
            }
            if(i > 0) mini = Math.min(mini, prefixLength);
            i++;
        }
        return strs[0].substring(0, mini);
    }
}