/*
108. Convert Sorted Array to Binary Search Tree

Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.


Example 1:
Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:
Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return compute(nums, 0, nums.length - 1);
    }

    private TreeNode compute(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode curr = new TreeNode(nums[mid]);
        curr.left = compute(nums, left, mid - 1);
        curr.right = compute(nums, mid + 1, right);
        return curr;
    }
}

/***
 * 이 문제는 balanced-BSTs를 구하는 문제이다.
 *
 * 일단 개념은 중간 값을 이용해서 재귀적으로 노드를 구성하는 것이다.
 * 맨처음에 compute함수에 nums와 left, right를 각각 준다.
 * 그리고 중간값을 mid로 찾아준다.
 * 그 노드를 curr노드로 시작한다.
 * curr.left는 이제 왼쪽을 의미하기에 nums에서 mid아래에 있는 값을 기준으로 compute함수를 작성한다.
 * curr.right는 이제 오른쪽을 의미하기에 nums에서 mid위에 있는 값을 기준으로 compute함수를 작성한다.
 * 이후 curr를 반환하면 된다.
 */