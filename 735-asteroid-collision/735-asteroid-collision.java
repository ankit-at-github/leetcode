class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<asteroids.length; i++)
        {
            if(asteroids[i] > 0)
            {
                st.push(asteroids[i]);
            }
            else
            {
                while(!st.isEmpty() && st.peek() > 0 && Math.abs(asteroids[i]) > st.peek())
                {
                    st.pop();
                }
                if(st.isEmpty() || st.peek() < 0) st.push(asteroids[i]);
                else if(Math.abs(asteroids[i]) == st.peek()) st.pop();
            }
        }
        
        int[] ans = new int[st.size()];
        int index = st.size()-1;
        while(!st.isEmpty()) ans[index--] = st.pop();
        
        return ans;
        
    }
}