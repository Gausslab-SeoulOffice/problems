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
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

/***
 * 이건 트리의 깊이를 물어보는 문제이다.
 *
 * 일단 아무것도 없으면 깊이조차 없는것이기에 root == null 이면 0을 return한다.
 * 그리고 각각 오른쪽 왼쪽을 확인해서 더 깊은 걸 봐야한다.
 * Math.max를 하면 더 숫자가 높은 걸 채택하라는 것이다.
 * 그리고 maxDepth를 다시 돌릴건데, 왼쪽, 오른쪽을 나눠서 돌리게 된다.
 * [2, 9, 20, null, null, 15, 7] 이런식으로 있으면 maxDepth(root.left)는 [9], maxDepth(root.right)는 [20, 15, 7] 이렇게 나오고,  [9]는 1+Math.max(0,0)이기에 1이 나온다.
 * [20, 15, 7]에서 다시, maxDepth(root.left)는 [15], maxDepth(root.right)는 [7]이 나온다.
 * [15]는 1+Math.max(0,0) =1, [7]은 1+Math.max(0,0) =1으로 maxDepth(root.right)는 [20, 15, 7] = 2가 된다.
 * 다시 돌아오면 [20]은 1+Math.max(1,1) =2가 되고, [root]는 1+Math.max(1,2) =3이 되기에 3을 return하면 된다.
 */