class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList<>();
        int i=0, j=0;
        while(i < firstList.length && j < secondList.length){
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            
            //possible answer so add to the ans list
            if(end >= start){
                ans.add(new int[]{start, end});
            }
            
            //remove interval with smallest endpoint as it would have been added in ans
            if(firstList[i][1] < secondList[j][1]) i++;
            else j++;
            
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}