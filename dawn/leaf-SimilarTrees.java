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

    private void dfs(TreeNode root, List<Integer> leafValues) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                leafValues.add(root.val);
            }
            dfs(root.left, leafValues);
            dfs(root.right, leafValues);
        }
    }
}

/***
 * 이 문제는 두개의 tree가 있을때 리프노드가 똑같은지 확인하는 문제이다.
 *
 * 두개의 list를 만들어두고, 리프노드를 이 리스트에 각각 넣을것이다.
 * 이후에 이 두개의 리스트가 같은지 확인해서 반환하면 된다.
 * 리프노드를 찾아서 리스트에 넣는것은 dfs라는 함수를 이용한다.
 * 리프노드는 자식노드가 모두 없을때 리프노드라고 부른다.
 * root.left, root.right가 둘 다 null이면 리프노드이기때문에 list에 넣는다.
 */