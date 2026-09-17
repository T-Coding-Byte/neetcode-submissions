# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Array of rightmost nodes at each level
# BFS, attach rightmost node (last node added)
#
##
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        unsearched = deque()
        unsearched.append(root)
        if root == None:
            return result

        while(unsearched):
            levelSize = len(unsearched)
            for i in range(levelSize):
                currentNode = unsearched.popleft()
                if currentNode.left:
                    unsearched.append(currentNode.left)
                if currentNode.right:
                    unsearched.append(currentNode.right)
            result.append(currentNode.val)
            
        
        return result
        