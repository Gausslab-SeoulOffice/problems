/*
1372. Longest ZigZag Path in a Binary Tree

You are given the root of a binary tree.

A ZigZag path for a binary tree is defined as follow:

Choose any node in the binary tree and a direction (right or left).
If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
Change the direction from right to left or from left to right.
Repeat the second and third steps until you can't move in the tree.
Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

Return the longest ZigZag path contained in that tree.


Example 1:
Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1]
Output: 3
Explanation: Longest ZigZag path in blue nodes (right -> left -> right).

Example 2:
Input: root = [1,1,1,null,1,null,null,1,1,null,1]
Output: 4
Explanation: Longest ZigZag path in blue nodes (left -> right -> left -> right).

Example 3:
Input: root = [1]
Output: 0
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
    int max = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        longestZigZag(root.left, 1, false);
        longestZigZag(root.right, 1, true);
        return max;
    }

    private void longestZigZag(TreeNode root, int count, boolean goLeft) {
        if (root == null)
            return;

        max = Math.max(max, count);

        if (goLeft) {
            longestZigZag(root.left, count + 1, false);
            longestZigZag(root.right, 1, true);
        } else {
            longestZigZag(root.right, count + 1, true);
            longestZigZag(root.left, 1, false);
        }
    }
}

/***
 * 이 문제는 right, left를 왔다갔다해서 최대한 길게 가는 횟수가 얼마인지 반환하는 문제이다.
 *
 * 왼쪽으로 갔으면 이제 오른쪽으로 가야하기 때문에 longestZigZag(root.left, 1, false)가 되어야한다.
 * 오른쪽으로 갔으면 이제 왼쪽으로 가야하기 때문에 root.right이면 true가 되어야한다.
 * 그리고 max를 업데이트 해줘야하고, 왼쪽으로 갔는지 오른쪽으로 갔는지에 따라서 다시 한번 확인해야한다.
 * 이전에 오른쪽으로 온거면 이제 왼쪽으로 가야하기때문에 다시 오른쪽으로 가는 것에는 count를 1로 해주고, true로 해야한다. 반대도 잘 생각해서 반대로 가야한다.
 */