/*
637. Average of Levels in Binary Tree

Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.


Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].

Example 2:
Input: root = [3,9,20,15,7]
Output: [3.00000,14.50000,11.00000]
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root == null)
            return result;
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Double sum = 0.0;
            for (int i = 0; i < n; i++) {
                TreeNode curr = queue.poll();
                sum += curr.val;
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }
            result.add(sum / n);
        }
        return result;
    }
}

/***
 * 이 문제는 BFS로 같은 층에 있는 숫자들의 평균을 구하는 문제이다.
 *
 * 일단  root가 null이면 빈 result를 반환한다.
 * 그리고 queue에 root의 값을 넣는다.
 * queue가 비어있지 않으면 반복한다.
 * n은 queue에 들어가 노드의 수를 의미하고, sum은 노드들의 합을 의미한다.
 * 지금 queue에 있는 걸 curr로 가져오고, sum에 curr.val의 값을 더한다.
 * 그리고 자식 노드가 있는지 확인해서, 있으면 queue에 넣는다.
 * 그리고 sum/n으로 평균을 계산해서 result에 넣는다.
 * 그 다음 반복문은 자식노드들의 평균을 또 구하는 방식이 될것이다.
 */