class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        for(int i=2; i<=numRows; i++){
            List<Integer> intermediateResult = new ArrayList<>();
            List<Integer> previousRow = result.get(i-2);
            for(int j=1; j<=i; j++){
                if(j == 1 || j == i) intermediateResult.add(1);
                else{
                    intermediateResult.add(previousRow.get(j-1) + previousRow.get(j-2));
                }
            }
            result.add(intermediateResult);
        }
        return result;
    }
}