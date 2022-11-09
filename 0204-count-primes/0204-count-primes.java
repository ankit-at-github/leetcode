class Solution {
    public int countPrimes(int n) {
        if(n < 2) return 0;
        
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        
        for(int i=2; i<n; i++)
        {
            for(int j=2; j*i<n; j++)
            {
                prime[j*i] = false;
            }
        }
        
        
        int count = 0;
        for(int i=2; i<n; i++) if(prime[i]) count++;
        return count;
    }
}