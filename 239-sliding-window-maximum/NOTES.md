This approach gives TLE
​
int[] ans = new int[nums.length-k+1];
int left = 0, right = 0;
PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);
while(right < nums.length)
{
if(right - left < k)
{
pq.add(new int[]{nums[right], right});
right++;
}
if(right - left == k) ans[left++] = pq.peek()[0];
while(!pq.isEmpty() && pq.peek()[1] < left) pq.poll();
}
return ans;