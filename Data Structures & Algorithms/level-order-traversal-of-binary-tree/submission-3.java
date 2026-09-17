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
//BFS
//each level is just the queue after you pop node
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        
        Queue<TreeNode> unsearched = new ArrayDeque<>();;
        ArrayList<Integer> level = new ArrayList<>();
        
        unsearched.add(root);
        level.add(root.val);
        result.add(level);

        while(!unsearched.isEmpty()){
            int size = unsearched.size();
            level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode current = unsearched.poll();
                if(current.left != null){
                    unsearched.add(current.left);
                    level.add(current.left.val);
                }
                if(current.right != null){
                    unsearched.add(current.right);
                    level.add(current.right.val);
                }
            }

            if(!level.isEmpty()) result.add(level);
        
        }
        return result;


    }
}
