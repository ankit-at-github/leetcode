class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int ones = 0;
        Map<Integer, List<Integer>> tmap = new TreeMap<>();
        for(int i=0; i<mat.length; i++)
        {
            ones = 0;
            for(int j=0; j<mat[i].length; j++)
            {
                if(mat[i][j] == 1) ones++;
            }
            if(!tmap.containsKey(ones)) tmap.put(ones, new ArrayList());
            tmap.get(ones).add(i);
        }
        
        int[] ans = new int[k];
        int index = 0;
        for(List l : tmap.values())
        {
            for(int i=0; i<l.size(); i++)
            {
                ans[index++] = (Integer) l.get(i);
                if(index == k) break;
            }
            if(index == k) break;
        }
        
        return ans;
        
    }
}