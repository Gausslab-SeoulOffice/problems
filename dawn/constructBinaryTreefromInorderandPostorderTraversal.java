/*
106. Construct Binary Tree from Inorder and Postorder Traversal

Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.


Example 1:
Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: inorder = [-1], postorder = [-1]
Output: [-1]
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Deque<Integer> postorderQueue = new ArrayDeque<>();
        for (int i = postorder.length - 1; i >= 0; i--) {
            postorderQueue.offer(postorder[i]);
        }
        return build(inorder, postorderQueue);
    }

    private TreeNode build(int[] inorder, Deque<Integer> postorderQueue) {
        if (inorder.length > 0) {
            int idx = indexOf(inorder, postorderQueue.poll());
            TreeNode root = new TreeNode(inorder[idx]);

            root.right = build(Arrays.copyOfRange(inorder, idx + 1, inorder.length), postorderQueue);
            root.left = build(Arrays.copyOfRange(inorder, 0, idx), postorderQueue);
            return root;
        }
        return null;
    }

    private int indexOf(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}

/***
 * 이 문제도 저번이랑 비슷하다. 주어진 것만 좀 다른데 inorder와 postorder가 주어진다.
 *
 * 전 문제보다 좀 더 신경 써야하는 부분은 Deque에 넣을때 뒤에서 부터 넣는다는 것이다.
 * [9, 15, 7, 20, 3] 이렇게라면 3 -> 20 -> 7 -> 15 -> 9 이런식으로 들어가야한다.
 * 그리고는 거의 비슷한데 한 군데 더 신경써야하는 부분은 postorder같은 경우 오른쪽 노드부터 쓰이기때문에, aㅏ만들때도 root.right를 root.left보다 먼저 만들어줘야한다는 것이다.
 */