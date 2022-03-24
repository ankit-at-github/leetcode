class Solution {
    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        
        long modulo = (int)1e9+7;
        long profit = 0;
        long count = 1;
        for(int i=inventory.length-1; i>=0 && orders>0; i--)
        {
            long current = inventory[i];
            long prev = (i == 0 ? 0:inventory[i-1]);
            //Take minimum number of orders that can be accomodated.
            long rounds = Math.min(orders/count, current-prev);
            //Reduce the number of orders by orders taken from all rounds.
            orders-=rounds*count;
            profit = (profit + (current*(current+1) - (current-rounds)*(current-rounds+1))/2 * count)%modulo;
            if(current-prev > rounds)
            {
                profit = (profit + orders*(current-rounds))%modulo;
                break;
            }
            count++;
        }
        
        return (int)profit;
    }
}