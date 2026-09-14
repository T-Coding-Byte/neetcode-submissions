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

//dfs while tracking class parameter
//try do it recursively
class Solution {
    int depth = 0;

    public static int recurse(TreeNode root, int d){
        if(root == null){
            return d;
        }
        return Math.max(recurse(root.left, d+1), recurse(root.right, d+1));
    
    }
    public int maxDepth(TreeNode root) {
        return recurse(root,0);
    }
}
