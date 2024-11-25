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
    int answer = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return answer;
    }
    private int depth(TreeNode root){
        if(root == null){
            return -1;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        answer = Math.max(answer, left+right+2);

        return Math.max(left, right)+1;
    }
}