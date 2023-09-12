class Solution {
    public int minDeletions(String s) {
        int[] map = new int[26];
        for(char c : s.toCharArray()) map[c-'a']++;
        
        Arrays.sort(map);
        
        int deleteCount = 0;
        int expectation = map[25]-1;
        //The expected count for previous string would be less than the previous count seen, taking 1 count less
        //than the last count of character, if last count is 0 then expected count becomes negative update it 
        //while traversing the map
        for(int i=24; i>=0; i--)
        {
            if(map[i] == 0) break;
            
            if(map[i] > expectation) deleteCount+=map[i]-expectation;
            else expectation = map[i];
            
            if(expectation > 0) expectation--;
        }
        return deleteCount;
    }
}