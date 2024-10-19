class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int[] index = q.poll();
            int x = index[0];
            int y = index[1];
            ans.add(nums.get(x).get(y));
            
            //checking if next row exist in current column
            if(y == 0 && x + 1 < nums.size()){
                q.add(new int[]{x+1, y});
            }
            //checking if next element exist in current row (Right Side)
            if(y+1 < nums.get(x).size()){
                q.add(new int[]{x, y+1});
            }
            
        }
        int[] result = new int[ans.size()];
        int i = 0;
        for(int num : ans){
            result[i++] = num;
        }
        return result;
    }
}