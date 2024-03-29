class Solution {
    public int countPrimes(int n) {
        if(n < 2) return 0;
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        
        int count = 0;
        for(int i=2; i<n; i++)
        {
            if(prime[i]) count++;
            for(int j=2; i*j < n; j++) prime[i*j] = false;
        }
        return count;
    }
}