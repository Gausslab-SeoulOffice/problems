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
        if(root == null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

/***
 * 이 문제는 트리의 깊이를 알아내라는 문제이다.
 *
 * 일단 root가 null이면 아무것도 없는것이기에 0을 리턴한다.
 * 그리고 왼쪽트리, 오른쪽트리를 확인하면서 내려간다.
 * 아래로 내려갈수록 깊이가 1만큼 늘어나는 것이기때문에 1+를 해주고 재귀로 내려간다.
 */