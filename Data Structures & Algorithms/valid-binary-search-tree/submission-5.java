class Solution {
    //1 = left
    //-1 = right

    public boolean dfs(TreeNode currentNode, TreeNode parent, int leftRight, long min, long max){
        if(currentNode == null) return true;

        if(currentNode.val <= min || currentNode.val >= max) {
            return false;
            }

        boolean left = dfs(currentNode.left, currentNode, 1, min, currentNode.val);
        boolean right = dfs(currentNode.right, currentNode, -1, currentNode.val, max);
        
        return left && right;
    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, 1, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}