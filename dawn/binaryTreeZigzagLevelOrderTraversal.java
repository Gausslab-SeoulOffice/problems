/*
103. Binary Tree Zigzag Level Order Traversal

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).


Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean reverse = false;
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
            if (reverse) {
                Collections.reverse(list);
                result.add(list);
                reverse = false;
            } else {
                result.add(list);
                reverse = true;
            }
        }
        return result;
    }
}

/***
 * 이 문제는 저번 문제랑 거의 비슷한데 지그재그로 list를 반환하길 원하는 문제이다.
 *
 * 거의 비슷하고 지그재그만 해결하면 된다는 생각이였다,
 * 알던 결과를 담을 result를 선언하고, 노드들 담을 queue를 선언한다.
 * 그리고 지그재그를 위해 reverse라는 boolean변수를 선언한다.
 * root가 null이면 비어있는 result를 반환한다,
 * queue에 root를 넣고, queue가 비어있지 않으면 반복문을 계속한다.
 * curr에 queue.poll()로 넣어주고, 이제 오른쪽 왼쪽을 확인하면서 같은 레벨에 있는 노드를 list에 넣는다.
 * 그리고 나서 리스트별로 지그재그로 해줘야한다.
 * reverse라는 변수로 한개는 list를 Collections.reverse로 뒤집어서 다시 result에 넣고, 그 다음거는 그대로 넣는다.
 * 이러면 리스트별로 지그재그로 들어가는걸 볼 수 있다.
 * 그 이후엔 최종적으로 result를 반환한다.
 */