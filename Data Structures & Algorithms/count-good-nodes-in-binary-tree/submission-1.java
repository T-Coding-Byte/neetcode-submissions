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

//dfs where we track the largest value recorded so far, 15:18
class Solution {
    //how do you iterate the size of the treeNode
    int goodNodes = 0;


    public void recursive(TreeNode currentNode, int maxVal){
        if(currentNode == null) return;

        if(currentNode.val >= maxVal){ 
            maxVal = currentNode.val; 
            goodNodes++;
            }
        else{
            
            System.out.println(currentNode.val);
            }

        recursive(currentNode.left, maxVal);
        recursive(currentNode.right, maxVal);

    }



    public int goodNodes(TreeNode root) {
        recursive(root, -100);
        return goodNodes;
    }
}
