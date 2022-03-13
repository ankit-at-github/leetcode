class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> factors = new ArrayList<>();
        factors.add(1);
        for(int i=2; i<=n; i++) if(n%i==0) factors.add(i);
        
        if(k > factors.size()) return -1;
        else return factors.get(k-1);
    }
}