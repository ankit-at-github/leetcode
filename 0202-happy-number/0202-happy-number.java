class Solution {
    public boolean isHappy(int n) {
        Set<Integer> st = new HashSet<>();
        while(n != 1){
            n = getSSD(n);
            if(st.contains(n)) return false;
            st.add(n);
        }
        return true;
    }
    public int getSSD(int n){
        int sum = 0;
        while(n > 0){
            int d = n % 10;
            sum += d*d;
            n/=10;
        }
        return sum;
    }
}