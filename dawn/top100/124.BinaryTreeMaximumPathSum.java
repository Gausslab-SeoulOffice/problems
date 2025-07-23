/*
124. Binary Tree Maximum Path Sum

A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.


Example 1:
Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.

Example 2:
Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
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
    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        sumNode(root);
        return result;
    }

    private int sumNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, sumNode(root.left));
        int right = Math.max(0, sumNode(root.right));
        result = Math.max(result, root.val + left + right);
        return root.val + Math.max(left, right);
    }

}

/***
 * 이 문제는 최대 값을 찾아서 합을 구하는 문제이다.
 *
 * 일단 왼쪽 노드를 최대 값으로 구하고, 오른쪽 노드도 최대값으로 구해야한다.
 * 그리고 result에 값을 더해주면 된다.
 * 현재 있는 곳에서 left, right노드 3개를 합한것과 기존에 있는 result를 비교해서 더 큰 값을 result로 설정해둔다.
 * 그리고 left, right를 구할때 int로 받아야하기때문에 return을 해주면 된다.
 */