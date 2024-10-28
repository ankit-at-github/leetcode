class Solution {
    public String simplifyPath(String path) {
        String[] components = path.split("/");
        Stack<String> st = new Stack();
        for(String component : components){
            if(component.equals("") || component.equals(".")) continue;
            
            if(component.equals("..")){
                if(!st.isEmpty()) st.pop();
            }
            else{
                st.push(component);
            }
        }
        StringBuilder cPath = new StringBuilder();
        for(String dir : st){
            cPath.append("/");
            cPath.append(dir);
        }
        return cPath.length() == 0 ? "/" : cPath.toString();
    }
}