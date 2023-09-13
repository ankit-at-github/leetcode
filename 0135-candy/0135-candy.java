class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        
        //Assigning candies from left to right whoever has higher rating gets more candy
        for(int i=1; i<n; i++)
        {
            if(ratings[i] > ratings[i-1]) candies[i] = candies[i-1]+1;
        }
        
        //Assigning candies from right to left based on
        for(int i=n-1; i>0; i--)
        {
            if(ratings[i-1] > ratings[i]) candies[i-1] = Math.max(candies[i-1], candies[i]+1);
        }
        int total = 0;
        for(int x : candies) total+=x;
        return total;
    }
}