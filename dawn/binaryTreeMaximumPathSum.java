/*
124. Binary Tree Maximum Path Sum

A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.


Example 1:
Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.

Example 2:
Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
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
    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        sumNode(root);
        return result;
    }

    private int sumNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, sumNode(root.left));
        int right = Math.max(0, sumNode(root.right));
        result = Math.max(result, root.val + left + right);
        return root.val + Math.max(left, right);
    }

}

/***
 * 이 문제는 노드들의 합에서 가장 최대값을 찾는것이다. 단 path는 연결되어 있어야한다.
 *
 * 일단 최대값을 찾으려는거기에 result를 선언해서 그 값은 Integer.MIN_VALUE로 초기화 해준다.
 * 그리고 sumNode함수한테 전체 node를 넘기고, 최종 값인 result를 반환한다.
 * sumNode는 현재 노드를 루트로 하는 서브트리의 최대 경로 합을 구하는 재귀 함수이다.
 * root가 null이면 0을 반환하고, 그게 아니라면, 왼쪽 오른쪽에게 가장 큰 값을 가지고 올 예정이다.
 * sumNode(root.left), sumNode(root.right)를 호출하여 왼쪽과 오른쪽 서브트리의 최대 경로 합을 구한다.
 * Math.max(0, sumNode(root.left)): 음수가 나올 경우 0으로 처리(즉, 음수는 경로에 포함하지 않음)
 * 현재 노드를 루트로 하는 전체 경로 (root.val + left + right)를 계산하고, result를 갱신한다.
 * result는 모든 노드를 순회하면서 최대값을 찾아 업데이트된다
 * root.val+Math.max(left, right)는 현재 노드를 포함하는 단일경로(왼쪽 오른쪽 중 더 큰걸로)를 반환한다.
 * 부모 노드에서 이 값을 사용하여 최댓값을 계산하기 때문이다.
 */