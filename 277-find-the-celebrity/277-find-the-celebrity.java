/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int celebrity = 0;
        int j = 1;
        while(j < n)
        {
            if(knows(celebrity,j))
            {
                celebrity = j;
            }
            j++;
        }
        
        for(int i=0; i<n; i++)
        {
            if(i == celebrity) continue;
            
            //making sure if everyone knows celebrity and celebrity is known by everyone
            if(knows(celebrity, i) || !knows(i, celebrity)) return -1;
        }
        return celebrity;
    }
}