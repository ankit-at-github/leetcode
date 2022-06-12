class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = Integer.MIN_VALUE, num2 = Integer.MIN_VALUE, count1 = 0, count2 = 0;
        int n = nums.length;
        for(int x : nums)
        {
            if(x == num1) count1++;
            else if(x == num2) count2++;
            else if(count1 == 0)
            {
                count1 = 1;
                num1 = x;
            }
            else if(count2 == 0)
            {
                count2 = 1;
                num2 = x;
            }
            else 
            {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int x : nums)
        {
            if(x == num1) count1++;
            if(x == num2) count2++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if(count1 > n/3) ans.add(num1);
        if(count2 > n/3) ans.add(num2);
        return ans;
    }
}