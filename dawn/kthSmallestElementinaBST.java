/*
230. Kth Smallest Element in a BST

Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.


Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
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
    List<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        return list.get(k - 1);
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}

/***
 * 이 문제는 k번째 최소값을 찾는 문제이다.
 *
 * 일단 BFS는 중위순회로 오름차순이기 때문에 list에 값을 넣을것이다.
 * left값부터 list에 넣으면 list에 오름차순으로 들어갈것이다.
 * 그리고 이제 k번째 숫자를 return하면 되니까 인덱스이기때문에 k-1로 찾아서 return 하면 된다.
 */