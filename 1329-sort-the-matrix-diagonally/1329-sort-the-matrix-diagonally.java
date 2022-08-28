class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                if(!map.containsKey(i-j)) map.put((i-j), new PriorityQueue<>());
                map.get(i-j).add(mat[i][j]);
            }
        }
        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                mat[i][j] = map.get(i-j).poll();
            }
        }
        return mat;
    }
}