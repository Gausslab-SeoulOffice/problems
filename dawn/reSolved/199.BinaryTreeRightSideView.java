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
        List<Integer> list = new ArrayList<>();
        compute(root, list, 0);
        return list;
    }

    private void compute(TreeNode root, List<Integer> list, int depth) {
        if (root == null) {
            return;
        }
        if (depth == list.size()) {
            list.add(root.val);
        }
        compute(root.right, list, depth + 1);
        compute(root.left, list, depth + 1);
    }
}

/***
 * 이 문제는 깊이에서 제일 오른쪽에 있는 노드 리스트를 반환하라는 문제이다.
 *
 * 일단 list를 선언해서 계산 함수로 넘길예정이다.
 * 계산함수는 각 depth에서 한개씩 추가되어야하니까 depth를 인자로 받는다.
 * 만약 root가 null이면 바로 return하면 된다.
 * depth에서 한개씩 추가를 하기 때문에 list.size()가 depth랑 같으면 이제 딱 추가해야할 값이라는 의미이다.
 * 이런 경우 root.val를 list에 추가해준다.
 * 그리고 이제 왼쪽 트리, 오른쪽 트리를 확인해주어야하는데, 이때 제일 오른쪽에 있는 노드를 리스트에 추가해야하기 때문에 compute에 넘길때 root.right부터 넘겨야한다.
 */