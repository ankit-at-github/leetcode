class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getSSD(n);
        while(fast != 1 && fast != slow){
            slow = getSSD(slow);
            fast = getSSD(getSSD(fast));
            
        }
        return fast==1;
    }
    public int getSSD(int n){
        int sum = 0;
        while(n > 0){
            int d = n % 10;
            n/=10;
            sum += d*d;
        }
        return sum;
    }
}