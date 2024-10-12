class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) return "";
        int dotCount = 0;
        String[] absolutePath = path.split("/");
        Stack<String> st = new Stack<>();
        for(int i = 0; i < absolutePath.length; i++){
            if(absolutePath[i].length() != 0 && !absolutePath[i].equals(".")){
                if(absolutePath[i].equals("..")){
                    if(!st.isEmpty()) st.pop();
                }
                else{
                    st.push(absolutePath[i]);
                }
            }
        }
        StringBuilder canonicalPath = new StringBuilder();
        for(String dir : st){
            canonicalPath.append("/").append(dir);
        }
        return canonicalPath.length() > 0 ? canonicalPath.toString() : "/";
    }
}