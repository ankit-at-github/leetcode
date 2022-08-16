public class Codec {

    HashMap<String, List<String>> encode;
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        encode = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(String s : strs) sb.append(s+"#");
        encode.put(sb.toString(), strs);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        return encode.get(s);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));