class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> ans = new ArrayList<>();
        int carry = 1;
        for(int i=digits.length-1; i>=0; i--){
            int sum = digits[i] + carry;
            ans.add(sum % 10);
            carry = sum / 10;
        }
        if(carry != 0) ans.add(carry);
        int[] result = new int[ans.size()];
        int index = ans.size() - 1;
        for(int d : ans) result[index--] = d;
        return result;
    }
}