class Solution {
    public String freqAlphabets(String s) {
        Map<Integer, Character> hmap = new HashMap<>();
        for(int i=0; i<26; i++)
        {
            hmap.put(i+1, (char)(i+'a'));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++)
        {
            if(i+2 < s.length() && s.charAt(i+2) == '#')
            {
                String integer = s.substring(i, i+2);
                //System.out.println()
                sb.append(hmap.get(Integer.parseInt(integer)));
                i+=2;
            }
            else
            {
                sb.append(hmap.get(Integer.parseInt(Character.toString(s.charAt(i)))));
            }
        }
        return sb.toString();
    }
}