class Solution {
    /**
    The problem is great example to solve using brut force first and then come up with optimized solution.
    */
    public int minFlipsMonoIncr(String s) {
        int oneCount = 0;
        int flipCount = 0;
        for(int i=0; i<s.length(); i++)
        {
            /*counting number of ones in prefix.*/
            if(s.charAt(i)=='1') oneCount++;
            /* counting number of flips to make if we encounter '0' after number of prefix 1 */
            else flipCount++;
            
            /* if number of flips is more than number of ones then better to flip ones instead of zeroes.*/
            if(flipCount > oneCount) flipCount = oneCount;
        }
        
        return flipCount;
    }
}