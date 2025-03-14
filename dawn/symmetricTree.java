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
 * 이 문제는 root를 중심으로 대칭이 되는지 확인 하는 문제이다.
 *
 * 일단 tree이기때문에 계속 확인을 해야한다.
 * 그래서 함수 한개를 더 만들어주었다.
 * isMirror라는 함수이고, 여기서 오른쪽, 왼쪽 tree를 각각 확인하면 된다.
 * 일단 왼쪽 노드와 오른쪽 노드를 던저주고, 이 두개가 둘 다 null이면 둘 다 비어있는거기때문에 true이다.
 * 둘 중 한개만 비어있으면 false이다.
 * 둘 다 차있으면 확인해봐야한다.
 * 일단 tree의 값이 같아야하고, 그 tree에 붙어있는 오른쪽 왼쪽 트리가 같은지 확인해야한다.
 * 이때는 서로 대칭이 되야하기 때문에, t1.left와 t2.right가 같은지 확인해야하고, t1.right와 t2,left가 같은지 확인하는게 맞다.
 */