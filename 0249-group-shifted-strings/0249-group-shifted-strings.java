class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strings){
            //distance between each letter of string and first character is same
            int diff = s.charAt(0)-'a';
            char[] t = s.toCharArray();
            for(int i=0; i<t.length; i++){
                char d = (char) (t[i] - diff);
                if(d < 'a'){
                    d+=26;
                }
                t[i] = d;
            }
            String key = new String(t);
            if(!map.containsKey(key)) map.put(key, new ArrayList());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}