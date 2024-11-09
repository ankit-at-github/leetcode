class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strings){
            int diff = s.charAt(0) - 'a';
            char[] charArray = s.toCharArray();
            for(int i=0; i<s.length(); i++){
                char d = (char)(charArray[i] - diff);
                if(d < 'a'){
                    d+=26;
                }
                charArray[i] = d;
            }
            String key = new String(charArray);
            if(!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}