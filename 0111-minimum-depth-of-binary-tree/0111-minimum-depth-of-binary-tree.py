# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if not root:return 0
        
        mini = float('inf')
        def helper(node, depth):
            nonlocal mini
            if not node.left and not node.right:
                mini = min(mini, depth)
                
            if node.left:
                helper(node.left, depth+1)
                
            if node.right:
                helper(node.right, depth+1)
                
            return 
        helper(root, 1)
        return mini
        
        