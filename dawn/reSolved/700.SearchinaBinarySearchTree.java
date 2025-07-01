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
 * 이 문제는 val이 같은 트리를 찾아서 아래에 있는 하위 노드를 포함한 전체 트리를 반환하라는 문제이다.
 *
 * 일단 root가 null이면 null을 반환한다.
 * 그리고 root.val은 내가 현재 있는 값인데, 이 값과 찾으려는 값인 val이 동일하면 root를 반환하면 된다.
 * Binary Search Tree이기때문에 정렬이 되어 있다.
 * 만약 지금 값이 찾으려는 값보다 크면 왼쪽으로 가야하기 때문에 root.left로 가고, 아니면 root.right로 가면 된다.
 */