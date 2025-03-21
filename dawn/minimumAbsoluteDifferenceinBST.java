/*
530. Minimum Absolute Difference in BST

Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.


Example 1:
Input: root = [4,2,6,1,3]
Output: 1

Example 2:
Input: root = [1,0,48,null,null,12,49]
Output: 1
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
    int prev = Integer.MAX_VALUE;
    int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return result;
    }

    private void inOrder(TreeNode root) {
        if (root.left != null) {
            inOrder(root.left);
        }
        result = Math.min(result, Math.abs(root.val - prev));
        prev = root.val;
        if (root.right != null) {
            inOrder(root.right);
        }
    }
}

/***
 * 두 노드에서 가장 최소의 차이를 구하는 것이다.
 *
 * BST의 특징은 중위 순회(in-order traversal)를 하면 노드 값들이 오름차순으로 정렬된다는 것이다.
 * 중위 순회를 하면서 prev와 지금 노드 값의 차이를 구하고 제일 작은걸 result에 넣어서 반환할것이다.
 * if (root.left != null) {
 *         inOrder(root.left);  // 왼쪽 자식 먼저
 *     }
 *  result = Math.min(result, Math.abs(root.val - prev));  // 이전 값과의 차이 비교
 *     prev = root.val;  // 현재 값을 다음 비교를 위해 prev에 저장
 * 이렇게 진행된다.
 */