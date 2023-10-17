class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        List<Integer> first_row = new ArrayList<>();
        first_row.add(1);
        
        triangle.add(first_row);
        
        for(int i=1; i<=rowIndex; i++)
        {
            List<Integer> prev_row = triangle.get(i-1);
            
            List<Integer> curr_row = new ArrayList<>();
            curr_row.add(1);
            
            for(int j=0; j<prev_row.size()-1; j++) curr_row.add(prev_row.get(j)+prev_row.get(j+1));
            
            curr_row.add(1);
            
            triangle.add(curr_row);
        }
        return triangle.get(rowIndex);
    }
}