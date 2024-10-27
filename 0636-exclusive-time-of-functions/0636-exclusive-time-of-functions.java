class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        int prevTime = 0;
        for(String log : logs){
            String[] parts = log.split(":");
            
            if(!st.isEmpty()){
                ans[st.peek()] += Integer.parseInt(parts[2]) - prevTime;
            }
            prevTime = Integer.parseInt(parts[2]);
            //pushing process currently running
            if(parts[1].equals("start")) st.push(Integer.parseInt(parts[0]));
            else{
                ans[st.pop()]++;
                prevTime++;
            }
            
        }
        
        return ans;
    }
}