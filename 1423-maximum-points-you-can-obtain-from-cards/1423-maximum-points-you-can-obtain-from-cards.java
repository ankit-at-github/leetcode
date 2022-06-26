class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum = 0;
        for(int points : cardPoints) totalSum+=points;
        
        if(n == k) return totalSum;
        
        int maxiPoints = 0, currentSum = 0, left = 0, right = 0;
        
        while(right < cardPoints.length)
        {
            currentSum+=cardPoints[right];
            if(right-left+1 == n-k)
            {
                maxiPoints = Math.max(maxiPoints, totalSum - currentSum);
                currentSum-=cardPoints[left];
                left++;
            }
            right++;
        }
        return maxiPoints;
    }
}