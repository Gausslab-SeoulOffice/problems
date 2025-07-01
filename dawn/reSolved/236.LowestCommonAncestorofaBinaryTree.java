/*
236. Lowest Common Ancestor of a Binary Tree

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”


Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Example 3:
Input: root = [1,2], p = 1, q = 2
Output: 1
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}

/***
 * 이 문제는 공통조상을 찾는 문제이다.
 *
 * 만약에 root가 null이거나 p나 q중에 root랑 같은게 있으면 그게 공통 조상을 의미하기 때문에 root를 반환하면 된다.
 * 그게 아니라면 이제 왼쪽트리나 오른쪽트리를 확인해야한다.
 * 거기서 만약에 left나 right 중 둘 다 null이 아니라면 왼쪽에서 하나, 오른쪽에서 한개를 찾았다는 의미이기에 root를 반환하면 된다.
 * 그것도 아니라면 이제 왼쪽 트리인지 오른쪽 트리인지 찾아서 둘 중 하나만 찾은 경우 위로 전달하는 방식이다.
 */