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
 * 이 문제는 BFS로 푸는 문제이다.
 * 각 레벨에 있는 노드값을 list로 반환하는 문제이다.
 *
 * queue를 사용해서 값을 저장하고 각 레벨마다 list로 옮겨서 최종적으로 result에 넣어 반환하면 된다.
 * 일단 맨 처음 root를 queue에 넣는다.
 * 그리고 queue에 값이 있으면 계속 반복해서 해준다.
 * 맨처음 queue에 있는 TreeNode를 빼서 그 노드의 왼쪽과 오른쪽에 값이 있으면 순서대로 queue에 넣어준다.
 * 그리고 list에 현재 값을 넣어준다.
 * 이후 for문을 다 돌면 result에 list들을 넣어주면 된다.
 * 마지막으로 result를 반환한다.
 */