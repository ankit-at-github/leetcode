class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> kSplit = new ArrayList<>();
        while(k > 0)
        {
            int d = k%10;
            kSplit.add(0,d);
            k/=10;
        }
        
        int i = num.length-1;
        int j = kSplit.size()-1;
        
        List<Integer> ans = new ArrayList<>();
        int carry = 0;
        while(i>=0 || j>=0)
        {
            int a = i>=0?num[i]:0;
            int b = j>=0?kSplit.get(j):0;
            
            int sum = a+b+carry;
            if(sum > 9)
            {
                ans.add(0,sum%10);
                carry = 1;
            }
            else
            {
                ans.add(0,sum);
                carry = 0;
            }
            
            i--;
            j--;
        }
        if(carry == 1) ans.add(0,1);
        return ans;
    }
}