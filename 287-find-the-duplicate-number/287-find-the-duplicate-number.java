class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int x : nums)
        {
            if(s.contains(x)) return x;
            s.add(x);
        }
        return -1;
    }
}