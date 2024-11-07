class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> ans = new ArrayList<>();
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        while(!q.isEmpty()){
            for(int i=q.size(); i>0; i--){
                int[] loc = q.poll();
                int x = loc[0];
                int y = loc[1];
                
                ans.add(nums.get(x).get(y));
                
                if(y == 0 && x + 1 < nums.size()){
                    q.add(new int[]{x+1, y});
                }
                
                if(y + 1 < nums.get(x).size()){
                    q.add(new int[]{x, y+1});
                }
            }
        }
        int[] result = new int[ans.size()];
        int index = 0;
        for(int x : ans) result[index++] = x;
        return result;
    }
}