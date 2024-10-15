class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> hashSet = new HashSet<>();
        int maxi = 0;
        int left = 0;
        for(int i=0; i<s.length(); i++){
            while(hashSet.contains(s.charAt(i))){
                hashSet.remove(s.charAt(left));
                left++;
            }
            maxi = Math.max(maxi, i - left + 1);
            hashSet.add(s.charAt(i));
        }
        return maxi;
    }
}