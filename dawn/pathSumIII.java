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

    private void pathSumHelper(TreeNode root, int targetSum, long currentSum) {
        if (root == null) {
            return;
        }

        currentSum += root.val;
        if (currentSum == targetSum) {
            count++;
        }
        pathSumHelper(root.left, targetSum, currentSum);
        pathSumHelper(root.right, targetSum, currentSum);
    }
}

/***
 * 이 문제는 누적합을 구해서 targetSum이 되는것이 몇개나 되는지 확인하는 문제이다.
 *
 * 일단 횟수를 세는 count를 선언한다.
 * 그리고 왼쪽 노드, 오른쪽 노드를 각각 확인해야한다.
 * 그리고 함수를 한개 지정한다.
 * 현재합을 같이 넘기는 함수이고, 현재값을 합에 더한다.
 * 합이 targetSum이 되면 count에 추가한다.
 * 그리고 이걸 가지고 또 돌려준다.
 */