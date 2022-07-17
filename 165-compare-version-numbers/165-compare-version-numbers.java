class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i=0, j=0;
        while(i < v1.length || j < v2.length)
        {
            int r1 = i>=v1.length?0:Integer.valueOf(v1[i]);
            int r2 = j>=v2.length?0:Integer.valueOf(v2[j]);
            
            if(r1 < r2) return -1;
            else if(r1 > r2) return 1;
            
            i++;j++;
        }
        return 0;
    }
}