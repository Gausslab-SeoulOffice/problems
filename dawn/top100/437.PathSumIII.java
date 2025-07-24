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
        pathSum(root.right, targetSum);
        pathSum(root.left, targetSum);
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
        pathSumHelper(root.right, targetSum, sum);
        pathSumHelper(root.left, targetSum, sum);
    }
}

/***
 * 이 문제는 숫자를 더해서 targetSum을 만들 수 있는 갯수를 구하는 문제이다.
 *
 * 갯수를 셀수 있는 count를 선언한다.
 * 그리거 맨 처음에는 sum을 0으로 시작해서 pathSumHelper를 돌린다.
 * pathSumHelper에서 root가 null이면 return;한다.
 * 그리고 sum에 root.val을 더해준다.
 * 만약 sum이랑 targetSum이 같으면 count를 증가시킨다.
 * 이후 pathSumHelper를 통해 다음 트리를 타고 내려가면서 계속 확인한다.
 * 각 트리를 확인하면 된다.
 * 이후 count를 반환하면 된다.
 */