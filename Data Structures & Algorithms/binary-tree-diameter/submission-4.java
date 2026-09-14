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

//recursivly DFS at each node?
class Solution {
    int diamater = 0;

    int DFS(TreeNode root){
        
        if (root == null) return 0;
        int left = DFS(root.left);
        int right = DFS(root.right);

        diamater = Math.max(diamater, left + right);
        return 1 + Math.max(left,right);
        
    }


    public int diameterOfBinaryTree(TreeNode root) {
        DFS(root);
        return diamater;

    }
}
