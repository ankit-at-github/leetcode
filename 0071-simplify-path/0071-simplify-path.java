class Solution {
    public String simplifyPath(String path) {
        String[] components = path.split("/");
        Stack<String> st = new Stack<>();
        for(String component : components){
            if(component.equals(".") || component.equals("")) continue;
            
            if(component.equals("..")){
                if(!st.isEmpty()) st.pop();
            }else{
                st.push(component);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String dir : st){
            sb.append("/");
            sb.append(dir);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}