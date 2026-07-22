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

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //go down until they are both not << or >> the root
        //if p < root and q > root, that is probably the common ancestor
        TreeNode current = root;
        boolean didntGoLeft = true;

        if((current.left == null) || (current.right == null)) return root;

        while((current.val > p.val) && (current.val > q.val)){
            current = current.left;
            didntGoLeft = false;
            System.out.println("left");
        }
        //if(didntGoLeft){
            while((current.val < p.val) && (current.val < q.val)){
                current = current.right;
                System.out.println("right");
            }
        //}
        if((root.val == current.val) && didntGoLeft) return root;
    
        return current;
    }
}
