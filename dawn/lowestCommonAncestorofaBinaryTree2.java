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
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}

/***
 * 이 문제는 p, q의 조상 노드를 구하는 문제이다.
 *
 * 일단 root가 없거나, root가 p이거나 q이면 root가 조상이니까 root를 반환한다.
 * 그리고 p와 q가 어디에 있는지 재귀로 확인한다.
 * left와 right가 둘 다 null 이 아니라면 p와 q가 서로 다른 서브트리에 있다는 뜻이다.
 * 현재 노드 root가 가장 가까운 공통 조상이다.
 * p와 q가 같은 서브트리에 있다면, 한 쪽만 결과가 나온다.
 * 그럼 그쪽 값을 위로 넘겨주고, 언젠가 두 개가 갈리는 시점에서 if (left != null && right != null)이 실행된다.
 */