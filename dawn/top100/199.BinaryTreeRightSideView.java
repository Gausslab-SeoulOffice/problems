/*
199. Binary Tree Right Side View

Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.


Example 1:
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]

Example 2:
Input: root = [1,2,3,4,null,null,null,5]
Output: [1,3,4,5]

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
 * 이 문제는 각 레벨에서 제일 오른쪽 노드를 리스트에 담아서 반환하는 문제이다.
 *
 * 일단 depth에서 제일 오른쪽 노드를 저장해야하기 때문에 맨 처음에는 depth를 0으로 준다.
 * 그리고 root가 null이면 바로 return;한다.
 * depth에 맨처음이 오른쪽 노드부터 들어오기때문에 depth와 result.size()가 같다는건 처음 들어온다는 의미를 가진다.
 * 그런경우에 result에 현재 값을 넣어준다.
 * 그리고 오른쪽 트리부터 확인해야 오른쪽 노드부터 들어가기 때문에 compute에 root.right부터 넣어주고, depth를 1증가시켜서 재귀로 탐색한다.
 * 이후 왼쪽 트리를 확인해준다.
 * 마지막으로 result를 반환해주면 된다.
 */