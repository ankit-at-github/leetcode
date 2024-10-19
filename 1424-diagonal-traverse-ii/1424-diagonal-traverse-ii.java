class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<List<Integer>> res = new ArrayList<>();
        int total = 0;
        for(int row = 0; row < nums.size(); row++){
            total+=nums.get(row).size();
            for(int col = 0; col < nums.get(row).size(); col++){
                if(res.size() < row+col+1) res.add(row+col, new ArrayList());
                res.get(row+col).add(0, nums.get(row).get(col));
            }
        }
        int[] ans = new int[total];
        int index = 0;
        for(int i=0; i<res.size(); i++){
            for(int j=0; j<res.get(i).size(); j++){
                ans[index++] = res.get(i).get(j);
            }
        }
        return ans;
    }
}