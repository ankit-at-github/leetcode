class Solution {
    public int triangularSum(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        for(int x : nums) q.add(x);
        
        while(q.size() > 1)
        {
            for(int i=1; i<=q.size()-1; i++)
            {
                int a = q.poll();
                int sum = a + q.peek();
                q.add(sum%10);
            }
            q.poll();
        }
        return q.poll();
    }
}