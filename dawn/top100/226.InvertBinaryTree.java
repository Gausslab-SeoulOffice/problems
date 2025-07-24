/*
226. Invert Binary Tree

Given the root of a binary tree, invert the tree, and return its root.


Example 1:
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]

Example 2:
Input: root = [2,1,3]
Output: [2,3,1]

Example 3:
Input: root = []
Output: []
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }
}

/***
 * 이 문제는 오른쪽 노드와 왼쪽 노드를 변경하는 문제이다.temp를 사용해서 위치를 저장한 후에 변경해주면 되는 문제이다.
 *
 * 일단 root가 null이면 null를 반환한다.
 * 그게 아니라면 temp를 선언해서 일단 right를 저장해둔다.
 * 그리고 root.right에 left를 옮겨주고, left에 temp에 저장해둔 right를 옮겨준다.
 * 이걸 반복하기 위해서 invertTree에 right, left를 각각 선언해서 재귀로 돌려준다.
 * 이후 root를 반환하면 된다.
 *
 *
 */