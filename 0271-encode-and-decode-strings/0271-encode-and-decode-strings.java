public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encode = new StringBuilder();
        for(String str : strs){
            encode.append(str.length()).append("#").append(str);
        }
        return encode.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while(i < s.length()){
            int j = i;
            
            //Finding length of string
            while(s.charAt(j) != '#') j++;
            
            int strLength = Integer.parseInt(s.substring(i, j));
            
            //Extract String
            String str = s.substring(j+1, j+1+strLength);
            ans.add(str);
            
            i = j+1+strLength;
        }
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));