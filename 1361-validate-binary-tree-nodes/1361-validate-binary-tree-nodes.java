class Solution {
   public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int root = findRoot(leftChild, rightChild);
        return root >= 0 && bfs(root, leftChild, rightChild);
    }
    // Confirm there is 1 and only 1 root.
    private int findRoot(int[] leftChild, int[] rightChild) {
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < leftChild.length; ++i) {
            seen.add(i); // Add each node into HashSet.
        }
        for (int[] kids : new int[][]{leftChild, rightChild}) {
            for (int kid : kids) {
                if (kid >= 0 && !seen.remove(kid)) { // kid has more than 1 parent?
                    return -1;
                }
            }
        }
        return seen.size() == 1 ? seen.iterator().next() : -1; // Only 1 root?
    }
    // BFS starting from root to check if we can traverse each 
    // node once and only once.
    private boolean bfs(int root, int[] leftChild, int[] rightChild) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(root); // BFS starts from root.
        Set<Integer> seen = new HashSet<>(q);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int kid : new int[]{leftChild[node], rightChild[node]}) {
                if (kid >= 0 && seen.add(kid)) {
                    q.offer(kid);
                }
            }
        }
        return seen.size() == leftChild.length;
    }
}