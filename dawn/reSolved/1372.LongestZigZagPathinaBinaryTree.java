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
        if (root == null) {
            return;
        }
        max = Math.max(max, count);
        if (goLeft) {
            longestZigZag(root.left, count + 1, false);
            longestZigZag(root.right, 1, true);
        } else {
            longestZigZag(root.left, 1, false);
            longestZigZag(root.right, count + 1, true);
        }
    }
}

/***
 * 이 문제는 지그재그로 나오는 노드가 있을때 간선의 갯수가 몇개인지 구하라는 문제이다.
 *
 * 일단 오른쪽 왼쪽으로 가는게 중요하기 떄문에 맨 처음에 왼쪽으로 갔으면 맨 마지막을 false로 해야한다.
 * 오른쪽으로 가면 맨 마지막을 true로 한다.
 * 이제 그 안에서 재귀로 확인을 하면 된다.
 */