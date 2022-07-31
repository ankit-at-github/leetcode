class Solution {
    public int maximumGroups(int[] grades) {
        int n = grades.length;
        int total = 0, k = 0;
        while(total + k + 1 <= n)
        {
            total+=++k;
        }
        return k;
    }
}