/*
112. Path Sum

Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.


Example 1:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.

Example 2:
Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There are two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.

Example 3:
Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }
        targetSum -= root.val;
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}

/***
 * 이 문제는 덧셈으로 targetSum이 가능한지 묻는 문제이다.
 *
 * 일단 경우의 수를 3개로 나눠서 생각했다.
 * 1번은 그냥 root가 null인 아예 값이 비어 있으면 false이다.
 * 2번은 root만 있고, leaf node가 없는 경우이다.
 * 이 경우 만약 targetSum과 root.val이 같은 경우는 true이고, 그게 아니라면 false이다.
 * 3번은 root, leaf node가 다 있는 경우이다.
 * 이 경우는 이제 한개씩 확인해봐야한다.
 * 일단 targetSum에서 지금 갖고있는 root.val을 빼고, 다시 순회해서 돌리는 방법이다.
 * left, right를 나눠서 다시 돌리게 되고, 언젠가는 root.val만 있고, leaf node가 없을때가 올것이다.
 * 그럼 그걸 확인해서 left, right 중 어딘가 한 곳만 있어도 true이다.
 */