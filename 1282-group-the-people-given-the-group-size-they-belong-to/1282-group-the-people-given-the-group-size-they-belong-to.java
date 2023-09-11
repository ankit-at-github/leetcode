class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> groups = new HashSet<>();
        for(int i=0; i<groupSizes.length; i++)
        {
            int group = groupSizes[i];
            groups.add(group);
            if(!map.containsKey(group)) map.put(group, new ArrayList<Integer>());
            map.get(group).add(i);
        }
        for(int group : groups)
        {
            List<Integer> current = new ArrayList<>();
            for(int n : map.get(group))
            {
                current.add(n);
                if(current.size() == group)
                {
                    ans.add(current);
                    current = new ArrayList<>();
                }
            }
        }
        return ans;
    }
}