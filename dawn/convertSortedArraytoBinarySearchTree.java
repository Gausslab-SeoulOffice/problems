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
        return compute(nums, 0, nums.length-1);
    }

    private TreeNode compute(int[] nums, int left, int right){
        if(left> right){
            return null;
        }

        int mid = left + (right-left) /2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = compute(nums, left, mid-1);
        node.right = compute(nums, mid+1, right);
        return node;
    }
}

/***
 * 이 문제는 정렬된 배열을 높이 균형 이진 탐색 트리(Height-balanced BST)이다.
 *
 * 트리의 왼쪽과 오른쪽 가지가 거의 비슷한 길이를 가지는 트리이다.
 * 즉, 어떤 노드든지 왼쪽 서브트리와 오른쪽 서브트리의 높이 차이가 1 이하여야 한다.
 *
 * 그래서 중간값을 찾고, 그걸 기준으로 오른쪽 노트 왼쪽노드는 나눠서 재귀로 푸는 방식이다.
 */