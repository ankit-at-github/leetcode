class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1) return s;
        
        StringBuilder[] row = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++) row[i] = new StringBuilder();
        
        int currRow = 0;
        int diff = 1;
        for(char ch : s.toCharArray())
        {
            row[currRow].append(ch);
            
            if(currRow == numRows - 1) diff = -1;
            else if(currRow == 0) diff = 1;
            
            currRow+=diff;
        }
        
        StringBuilder ans = new StringBuilder();
        for(StringBuilder r : row) ans.append(r);
        
        return ans.toString();
    }
}