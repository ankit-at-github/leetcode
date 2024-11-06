class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        TreeMap<Integer, List<Integer>> tmap = new TreeMap<>();
        for(int num : arr){
            int diff = Math.abs(num - x);
            if(!tmap.containsKey(diff)) tmap.put(diff, new ArrayList());
            tmap.get(diff).add(num);
        }
        List<Integer> ans = new ArrayList<>();
        for(List<Integer> l : tmap.values()){
            for(int n : l){
                ans.add(n);
                if(ans.size() == k){
                    Collections.sort(ans);
                    return ans;
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}