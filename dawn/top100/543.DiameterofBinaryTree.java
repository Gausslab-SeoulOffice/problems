/*
543. Diameter of Binary Tree

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.


Example 1:
Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

Example 2:
Input: root = [1,2]
Output: 1
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
    int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return result;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        result = Math.max(result, left + right + 2);
        return Math.max(left, right) + 1;
    }
}

/***
 * 이 문제는 가장 긴 간선의 깊이를 구하는 문제이다.
 *
 * 일단 간선을 세는 변수를 count로 선언한다.
 * depth함수를 만들어준다.
 * root가 null이라면 리프노드라는 의미이고 이건 일단 -1로 반환한다.
 * left와 right를 각각 depth로 구한다.
 * result는 가장 긴 간선의 길이로 해야하기 때문에 result와 left+right+2로 해야한다.
 * 현재 노드에서 오른쪽, 왼쪽 길이를 해야하기 때문에 +2를 해준다.
 * 그리고 부모노드한테 길이를 반환해주어야하기 때문에 left,right중 긴것중에 +1을 해준다.
 *       1
 *      / |
 *     2   3
 *    / |
 *   4   5
 * depth(4) → -1, -1 → 리턴 0
 * depth(5) → -1, -1 → 리턴 0
 * depth(2) → left=0, right=0 → 지름 후보 = 0+0+2=2 → 리턴 1
 * depth(3) → 리턴 0
 * depth(1) → left=1, right=0 → 지름 후보 = 1+0+2=3 → 최대 지름 = 3
 */