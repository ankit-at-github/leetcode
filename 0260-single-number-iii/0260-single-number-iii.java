class Solution {
    public int[] singleNumber(int[] nums) {
        int aXORb=0;
        for(int n : nums) aXORb^=n;
        
        int rightSetBit = aXORb & -aXORb;
        
        int a = 0;
        for(int num : nums)
        {
            if((num&rightSetBit) != 0) a^=num;
        }
        return new int[]{a, aXORb^a};
    }
}