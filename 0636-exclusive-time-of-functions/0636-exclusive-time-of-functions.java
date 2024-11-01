class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        int prevTime = 0;
        for(String log : logs){
            String[] components = log.split(":");
            if(components[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()]+=Integer.parseInt(components[2]) - prevTime;
                }
                st.push(Integer.parseInt(components[0]));
                prevTime = Integer.parseInt(components[2]);
            }else{
                result[st.pop()]+=Integer.parseInt(components[2]) - prevTime + 1;
                prevTime = Integer.parseInt(components[2]) + 1;
            }
        }
        return result;
    }
}