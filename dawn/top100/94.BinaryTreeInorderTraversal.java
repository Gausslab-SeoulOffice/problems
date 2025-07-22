/*
94. Binary Tree Inorder Traversal

Given the root of a binary tree, return the inorder traversal of its nodes' values.


Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]
Explanation:

Example 2:
Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
Output: [4,2,6,5,7,1,3,9,8]
Explanation:

Example 3:
Input: root = []
Output: []

Example 4:
Input: root = [1]
Output: [1]
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode root, List<Integer> result) {
        if (root == null)
            return;

        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }
}

/***
 * 이 문제는 inorder로 반환하라는 문제이다.
 *
 * 일단 값을 담을 result를 선언해준다.
 * 이후 inorder라는 함수를 돌린다.
 * root가 null이면 바로 return을 시킨다.
 * 그게 아니라면 inorde로 왼쪽 트리부터 돌린다.
 * 그리고 도착한 값을 result에 넣으면 된다.
 * 이후 right를 돌려서 result에 넣는다.
 * 마지막으로 result를 반환하면 된다.
 */