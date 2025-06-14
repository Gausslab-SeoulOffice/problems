/*
700. Search in a Binary Search Tree

You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.


Example 1:
Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]

Example 2:
Input: root = [4,2,7,1,3], val = 5
Output: []
 */

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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}

/***
 * 이 문제는 타켓을 주면 그걸 찾아서 그 tree를 반환하라는 문제이다.
 *
 * 일단 root가 null 이면 null를 반환한다.
 * root.val이 찾으려는 값과 같으면 그 root를 반환한다.
 * 지금 값이 찾으려는 값보다 크면 그보다 작은 값만 봐야하니까 왼쪽을 살펴야한다.
 * 그렇기 때문에 searchBST(root.left, val)로 넘기고, 반대인 경우는 오른쪽을 살펴야한다.
 */