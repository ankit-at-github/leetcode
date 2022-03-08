class Solution {
    public void setZeroes(int[][] matrix) {
        List<List<Integer>> indexes = new ArrayList<>();
        List<Integer> index = new ArrayList<>();
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[i].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    index.add(i);
                    index.add(j);
                    indexes.add(new ArrayList(index));
                    index = new ArrayList();
                }
            }
        }
        
        for(List<Integer> l : indexes)
        {
            int row = l.get(0);
            int col = l.get(1);
            
            for(int i=0; i<matrix[0].length; i++) matrix[row][i] = 0;
            for(int i=0; i<matrix.length; i++) matrix[i][col] = 0;
        }
    }
}