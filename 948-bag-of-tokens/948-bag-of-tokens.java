class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int maxPoints = 0;
        int points = 0;
        int left=0, right = tokens.length-1;
        while(left <= right)
        {
            if(power >= tokens[left])
            {
                points++;
                power-=tokens[left++];
                maxPoints = Math.max(maxPoints, points);
            }
            else if(power < tokens[left])
            {
                if(points > 0)
                {
                    points--;
                    power+=tokens[right--];
                }
                else return maxPoints;
            }
        }
        return maxPoints;
    }
}