# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if not root:return 0
        
#         mini = float('inf')
        def helper(node, depth):
            if not node.left and not node.right:
                # mini = min(mini, depth)
                
                return depth
                
            if node.left:
                mini_left = helper(node.left, depth+1)
            else:
                mini_left = float('inf')
                
            if node.right:
                mini_right = helper(node.right, depth+1)
            else:
                mini_right = float('inf')
                
            return min(mini_left, mini_right)
        mini = helper(root, 1)
        return mini
        
        