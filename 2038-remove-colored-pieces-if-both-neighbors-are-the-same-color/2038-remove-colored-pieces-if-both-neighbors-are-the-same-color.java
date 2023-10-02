class Solution {
    public boolean winnerOfGame(String colors) {
        //return true if count(AAA's) > count(BBB's) together.
        int countA = 0, countB = 0;
        for(int i=0; i<colors.length()-2; i++)
        {
            if(colors.charAt(i) == 'A' && colors.charAt(i+1) == 'A' && colors.charAt(i+2) == 'A') countA++;
            if(colors.charAt(i) == 'B' && colors.charAt(i+1) == 'B' && colors.charAt(i+2) == 'B') countB++;
        }
        return countA > countB;
    }
}