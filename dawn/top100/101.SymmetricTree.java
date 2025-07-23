/*
101. Symmetric Tree

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).


Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false
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
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}

/***
 * 이 문제는 좌우 트리가 있을때 거울모드로 같은지 확인하는 문제이다.
 *
 * 일단 isMirror라는 함수를 만들어준다.
 * 여기는 t1과 t2가 모두 null이라면 true를 반환한다.
 * 둘 중 한개만 null이라면 같지 않기 때문에 false를 반환한다.
 * 아직 트리가 남았으면 계속 확인해야하기때문에 일단 t1과 t2의 값이 같은지 확인하고, t1의 왼쪽과 t2의 오른쪽이 isMirror인지 확인하고, t1의 오른쪽과 t2의 왼쪽이 isMirror인지 확인헤서 return하면 된다.
 */