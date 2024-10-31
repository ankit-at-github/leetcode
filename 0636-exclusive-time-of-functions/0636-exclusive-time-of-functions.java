class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        int prevTime = 0;
        for(String log : logs){
            String[] components = log.split(":");
            if(!st.isEmpty()){
                result[st.peek()]+= Integer.parseInt(components[2]) - prevTime;
            }
            prevTime = Integer.parseInt(components[2]);
            if(components[1].equals("start")){
                st.push(Integer.parseInt(components[0]));
            }
            else{
                result[st.pop()]++;
                prevTime++;
            }
        }
        return result;
    }
}