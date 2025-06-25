/*
437. Path Sum III

Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).


Example 1:
Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.

Example 2:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3
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
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        pathSumHelper(root, targetSum, 0);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return count;
    }

    private void pathSumHelper(TreeNode root, int targetSum, long sum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        if (sum == targetSum) {
            count++;
        }
        pathSumHelper(root.left, targetSum, sum);
        pathSumHelper(root.right, targetSum, sum);
    }
}

/***
 * 이 문제는 targetSum을 찾는건데 경우의 수가 몇개가 나오는지 반환하는 문제이다.
 *
 * 일단 갯수를 세는건 count 이고, root가 null이면 0을 반환한다.
 * 그리고 pathSumHelper로 먼저 계산을 한다.
 * 맨처음 root부터 더해가면서 오른쪽 왼쪽 가지고 와서 더하면서 targetSum이랑 같으면 count를 추가하고, 계속 왼쪽 오른쪽내려가면서 확인한다.
 * 그리고 맨처음 root가 아니라 그 다음으로 넘어가려면 pathSum에 왼쪽 노드, 오른쪽 노드를 가지고 와서 재귀로 확인한다.
 */