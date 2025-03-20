/*
102. Binary Tree Level Order Traversal

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).



Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                list.add(curr.val);
            }
            result.add(list);
        }
        return result;
    }
}

/***
 * 이 문제는 같은 레벨의 노드를 리스트로 만들어서 List<List<Integer>>로 반환하는 문제이다.
 *
 * 일단 반환할 result를 만들고, 노드들을 넣을 queue를 선언한다.
 * 그리고 root가 null이면 비어있는 result를 반환한다.
 * queue에 root를 추가하고, queue가 비어있지 않으면 반복문을 한다.
 * 일단 queue의 크기는 n이고, 이제 list에 넣을것이다.
 * queue에 있는게 curr로 넣어주고, curr의 left랑 right에 노드가 있으면 queue에 넣어준다.
 * 그리고나서 curr.val를 list에 넣어준다.
 * 그 레벨에서 다 들어갔으면 result에 list를 넣어준 후, 최종적으로 result를 반환한다.
 */