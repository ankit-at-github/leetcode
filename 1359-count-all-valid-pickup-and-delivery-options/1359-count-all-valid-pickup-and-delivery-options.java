class Solution {
    public int countOrders(int n) {
        long cap = (long)1e9+7;
        long result = 1;
        //Possibilities for pickup n!
        for(int i=1; i<=n; i++) result = (result*i) % cap;
        //Possibilities for delivery
        for(int i=1; i<2*n; i+=2) result = (result*i) % cap;
        return (int)result;
    }
}