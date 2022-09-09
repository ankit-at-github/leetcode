class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        Set<Integer> st = new HashSet<>();
        String[] name = new String[n];
        int[] time = new int[n];
        int[] amount = new int[n];
        String[] city = new String[n];
        for(int i=0; i<transactions.length; i++)
        {
            String[] words = transactions[i].split(",");
            name[i] = words[0];
            time[i] = Integer.parseInt(words[1]);
            amount[i] = Integer.parseInt(words[2]);
            if(amount[i] > 1000) st.add(i);
            city[i] = words[3];
        }
        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                if(Math.abs(time[i]-time[j]) <= 60 && name[i].equals(name[j]) && !city[i].equals(city[j]))
                {
                    st.add(i);
                    st.add(j);
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for(int x : st) ans.add(transactions[x]);
        return ans;
    }
}