class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while(p1 < firstList.length && p2 < secondList.length){
            int start = Math.max(firstList[p1][0], secondList[p2][0]);
            int end = Math.min(firstList[p1][1], secondList[p2][1]);
            
            if(end >= start){
                result.add(new int[]{start, end});
            }
            
            if(end >= firstList[p1][1]) p1++;
            else p2++;
        }
        return result.toArray(new int[result.size()][2]);
    }
}