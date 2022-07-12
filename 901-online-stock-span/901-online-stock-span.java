class StockSpanner {
    Stack<Pair> st;
    int index = 0;
    int ans = 0;
    public StockSpanner() {
        st = new Stack<Pair>();
    }
    
    public int next(int price) {
        index++;
        if(st.isEmpty())
        {
            st.push(new Pair(price, index));
            return 1;
        }
        while(!st.isEmpty() && st.peek().price <= price) st.pop();
        if(st.isEmpty()) ans = index;
        else ans = (index - st.peek().index);
        st.push(new Pair(price, index));
        return ans;
    }
}
class Pair{
    int price;
    int index;
    Pair(int p, int i)
    {
        price = p;
        index = i;
    }
}
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */