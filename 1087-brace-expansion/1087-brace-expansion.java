class Solution {
    public String[] expand(String s) {
        int n = s.length();
        if (n == 0) {
            return new String[]{""};
        }
        if (n == 1) {
            return new String[]{s};
        }
        List<String> res = new ArrayList<>();
        if (s.charAt(0) == '{') {
            int count = 0;
            int i = 0;
            while (i < s.length()) {
                if (s.charAt(i) == '}') {
                    break;
                }
                i++;
            }
            String[] l = s.substring(1, i).split(",");
            String[] r = expand(s.substring(i + 1));
            for (String ll : l) {
                for (String rr : r) {
                    res.add(ll + rr);
                }
            }
        } else {
            String[] r = expand(s.substring(1));
            for (String rr : r) {
                res.add(s.charAt(0) + rr);
            }
        }
        Collections.sort(res);
        return res.toArray(new String[0]);
    }
}