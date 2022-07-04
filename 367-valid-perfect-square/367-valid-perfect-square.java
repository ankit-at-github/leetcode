class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        long low = 1, high = num/2+1;
        while(low < high)
        {
            long mid = low + (high-low)/2;
            long check = mid*mid;
            if(check == num) return true;
            else
            {
                if(check > num) high = mid;
                else low = mid+1;
            }
        }
        return false;
    }
}