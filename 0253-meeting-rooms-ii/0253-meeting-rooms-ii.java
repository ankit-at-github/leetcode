class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        int index = 0;
        for(int[] interval : intervals){
            start[index] = interval[0];
            end[index] = interval[1];
            index++;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int startPointer = 0, endPointer = 0;
        int usedRooms = 0;
        int maxRooms = 0;
        while(startPointer < n){
            if(start[startPointer] < end[endPointer]){
                usedRooms++;
                startPointer++;
            }else{
                usedRooms--;
                endPointer++;
            }
            maxRooms = Math.max(maxRooms, usedRooms);
        }
        return maxRooms;
    }
}