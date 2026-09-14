/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//DFS, make sure left - right < 2
class Solution {
    boolean balanced = true;

    public int DFS(TreeNode root){
        if(root == null) return 0;

        int left = DFS(root.left);
        int right = DFS(root.right);
        if (Math.abs(left - right) >= 2){
            balanced = false;
        }
        return 1 + Math.max(left, right);
        
    }


    public boolean isBalanced(TreeNode root) {
        //Self balancing, AVL, red black, etc
        DFS(root);
        return balanced;
    }
}
