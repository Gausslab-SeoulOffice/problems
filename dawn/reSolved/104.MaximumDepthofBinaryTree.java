/*
104. Maximum Depth of Binary Tree

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.


Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3

Example 2:
Input: root = [1,null,2]
Output: 2
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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

/***
 * 이 문제는 tree의 깊이를 구하는 문제이다.
 *
 * root가 null이면 아무것도 없다는 의미니까 0을 리턴한다.
 * 그게 아니라면 이제 오른쪽 왼쪽 트리를 확인해서 가장 깊은걸 찾아서 그걸 리턴하면 된다.
 * 왼쪽트리와 오른쪽 트리를 재귀로 찾아야한다.
 */