class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<List<Integer>> res = new ArrayList<>();
        int total = 0;
        for(int row = 0; row < nums.size(); row++){
            for(int col = 0; col < nums.get(row).size(); col++){
                if(res.size() < row+col+1) res.add(row+col, new ArrayList());
                res.get(row+col).add(0, nums.get(row).get(col));
                total++;
            }
        }
        int[] ans = new int[total];
        int index = 0;
        for(List<Integer> l : res){
            for(int n : l) ans[index++] = n;
        }
        return ans;
    }
}