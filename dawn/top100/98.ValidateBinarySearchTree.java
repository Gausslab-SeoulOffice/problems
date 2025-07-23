/*
98. Validate Binary Search Tree

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:
Input: root = [2,1,3]
Output: true

Example 2:
Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
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
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean valid(TreeNode root, long min, long max) {
        if (root == null)
            return true;

        if (!(root.val > min && root.val < max)) {
            return false;
        }
        return valid(root.left, min, root.val) && valid(root.right, root.val, max);
    }
}

/***
 * 이 문제는 순서대로 트리가 잘 정렬되어 있는지를 묻는 문제이다.
 *
 * 일단 확인을 해야하기때문에 valid라는 함수를 선언한다.
 * root가 null이라면 true를 반환한다.
 * 그리고 지금 내가 있는 값이 min보다 크고, max보다 작아야하는데, 그게 아니라면 false를 반환한다.
 * 그리고 왼쪽 트리 오른쪽 트리를 확인해야한다.
 * root.left를 확인하려면 min값을 주고 max 값은 내가 되어야한다.
 * root.right를 확인하려면 max값을 주고 min 값은 내가 되어야한다.
 * 이후 valid를 반환하면 된다.
 */