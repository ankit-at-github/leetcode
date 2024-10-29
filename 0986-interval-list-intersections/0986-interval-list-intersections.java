class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int p1 = 0, p2 = 0;
        List<int[]> result = new ArrayList<>();
        while(p1 < firstList.length && p2 < secondList.length){
            int maxStart = Math.max(firstList[p1][0], secondList[p2][0]);
            int minEnd = Math.min(firstList[p1][1], secondList[p2][1]);
            
            if(minEnd >= maxStart) result.add(new int[]{maxStart, minEnd});
            
            if(firstList[p1][1] < secondList[p2][1]) p1++;
            else p2++;
        }
        return result.toArray(new int[result.size()][2]);
    }
}