class Solution {
    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        int previousSum = 0, currentSum = 0;
        int previousCount = 0, currentCount = 0;
        int ans = 0;
        
        for(int grade : grades)
        {
            currentSum+=grade;
            currentCount++;
            
            if(currentSum > previousSum && currentCount > previousCount)
            {
                ans++;
                previousSum = currentSum;
                previousCount = currentCount;
                currentSum = 0;
                currentCount = 0;
            }
        }
        return ans;
    }
}