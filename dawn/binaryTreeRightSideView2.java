/*
199. Binary Tree Right Side View

Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.



Example 1:
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
Explanation:

Example 2:
Input: root = [1,2,3,4,null,null,null,5]
Output: [1,3,4,5]
Explanation:

Example 3:
Input: root = [1,null,3]
Output: [1,3]

Example 4:
Input: root = []
Output: []
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        compute(root, result, 0);
        return result;
    }

    private void compute(TreeNode root, List<Integer> result, int depth) {
        if (root == null) {
            return;
        }
        if (depth == result.size()) {
            result.add(root.val);
        }
        compute(root.right, result, depth + 1);
        compute(root.left, result, depth + 1);
    }

}

/***
 * 이 문제는 tree가 주어졌을때 가장 오른쪽에 있는 노드를 반환하라는 문제이다.
 *
 * 일단 오른쪽부터 탐색해서 깊이랑 같이 가면서 그 깊이에서 제일 먼저 탐색되는걸 list에 넣을 것이다.
 * 리스트를 List<Integer>로 한개 만들어주고, 재귀로 돌릴 예정이다.
 * 처음은 depth가 0이기 때문에 compute(root, result, 0)으로 넣어준다.
 * 그리고 compute함수에서 확인한다.
 * 일단 root가 null이면 없다는 의미이기에 return;을 반환한다.
 * 그리고 depth와 result.size()가 같다는 것은 그 depth에서 처음 나오는 노드라는 의미이고, 처음나온다는것은 제일 오른쪽에 나오는 노드라는 의미이다.
 * 그런 경우에 list에 넣어준다.
 * 그리고 오른쪽부터 재귀로 돌리면서 확인한다.
 */