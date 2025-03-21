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
        if (root == null) {
            return true;
        }
        if (!(root.val > min && root.val < max)) {
            return false;
        }
        return valid(root.left, min, root.val) && valid(root.right, root.val, max);
    }
}

/***
 * 이 문제는 트리가 BFS인지 아닌지 확인하는 문제이다.
 *
 * 중위순회이니까 왼쪽>루트>오른쪽이여야한다.
 * 그래서 min, max를 주고 비교를할것이다.
 * 현재 노드의 값이 min과 max 범위 안에 있어야 한다.
 * 왼쪽 자식은 max를 현재 노드 값으로 제한하고, 오른쪽 자식은 min을 현재 노드 값으로 제한한다.
 *       5
 *      / \
 *     3   7
 * 1단계:
 * valid(5, -∞, ∞)
 * 5는 범위 안이니까 → 계속 탐색
 * 왼쪽 자식 (3):
 * valid(3, -∞, 5)
 * 3 < 5 → OK
 * 오른쪽 자식 (7):
 * valid(7, 5, ∞)
 * 7 > 5 → OK
 */