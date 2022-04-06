class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int count = 0;
        int mod = (int)1e9+7;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++)
        {
            int newtarget = target - arr[i];
            map.clear();
            for(int j=i+1; j<arr.length; j++)
            {
                if(map.containsKey(newtarget - arr[j]))
                {
                    count = (count + map.get(newtarget-arr[j]))%mod;
                }
                map.put(arr[j], map.getOrDefault(arr[j], 0)+1);
            }
        }
        return count;
    }
}