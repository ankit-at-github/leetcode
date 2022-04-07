class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int count = 0;
        int mod = (int)1e9+7;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++)
        {
            if(map.containsKey(target - arr[i]))
                count = (count + map.get(target-arr[i]))%mod;
            for(int j=0; j<i; j++)
            {
                int twoSum = arr[i]+arr[j];
                map.put(twoSum, map.getOrDefault(twoSum, 0)+1);
            }
        }
        return count;
    }
}