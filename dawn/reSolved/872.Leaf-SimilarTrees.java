/*
872. Leaf-Similar Trees

Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.



For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.


Example 1:
Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
Output: true

Example 2:
Input: root1 = [1,2,3], root2 = [1,3,2]
Output: false
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        return list1.equals(list2);
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                list.add(root.val);
            }
            dfs(root.left, list);
            dfs(root.right, list);
        }
    }
}

/***
 * 이 문제는 tree가 두개 있을때 각 트리의 leaf노드가 동일한지 묻는 문제이다.
 *
 * leaf노드를 구하는건 dfs를 사용해서 구해야한다.
 * 일단 list를 각각 선언해두고 dfs를 사용해서 leaf노드를 list에 각각 넣으면 된다.
 * 그 이후 list1, list2를 비교해서 같으면 true, 다르면 false를 반환하면 된다.
 * dfs는 일단 root가 null이 아니여야 값이 있는것이고, 그 속에서 leaf노드인지를 찾아야한다.
 * leaf노드는 가지고 있는 왼쪽, 오른쪽 노드가 없는 것을 의미한다.
 * 그런 경우에 list에 추가하고, 그게 아니라면 다시 dfs로 leaf노드를 찾을때 까지 반복하면 된다.
 */