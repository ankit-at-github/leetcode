class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        
        dist1 = bfs(node1, edges, n);
        dist2 = bfs(node2, edges, n);
        
        int mini = Integer.MAX_VALUE;
        int index = -1;
        for(int i=0; i<n; i++)
        {
            if(dist1[i] == -1 || dist2[i] == -1) continue;
            
            if(mini > Math.max(dist1[i], dist2[i]))
            {
                index = i;
                mini = Math.max(dist1[i], dist2[i]);
            }
        }
        return index;
    }
    public int[] bfs(int src, int[] edges, int n)
    {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dist[src] = 0;
        while(!q.isEmpty())
        {
            int u = q.poll();
            //making sure that node is still un-explored
            if(edges[u] != -1 && dist[edges[u]] == -1)
            {
                q.add(edges[u]);
                dist[edges[u]] = dist[u] + 1;
            }
        }
        return dist;
    }
}