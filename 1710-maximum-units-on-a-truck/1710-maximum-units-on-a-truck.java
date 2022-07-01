class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1]-a[1]);
        int maxi = 0;
        int type = 0;
        while(truckSize > 0 && type < boxTypes.length)
        {
            int pick = Math.min(truckSize, boxTypes[type][0]);
            maxi+= boxTypes[type][1] * pick;
            truckSize-=pick;
            type++;
        }
        return maxi;
    }
}