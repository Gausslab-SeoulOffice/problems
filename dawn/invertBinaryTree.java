/*
226. Invert Binary Tree

Given the root of a binary tree, invert the tree, and return its root.


Example 1:
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]

Example 2:
Input: root =[[2,1,3]
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
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

/***
 * 이 문제는 왼쪽노드와 오른쪽 노드의 위치를 변경하라는 문제이다.
 *
 * 일단 root가 null이면 null를 반환한다.
 * 그리고 저장소인 temp Node를 한개 추가해서 root.left를 저장해놓는다.
 * 그리고 left에는 right 값을 넣고, right에는 left를 저장해놨던 temp를 넣는다.
 * 이걸 왼쪽, 오른쪽 모든 노드에 반영시켜주면 된다.
 * 그리고 root를 반환하면 된다.
 */