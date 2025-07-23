/*
114. Flatten Binary Tree to Linked List

Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.

Example 1:
Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [0]
Output: [0]
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
    Queue<TreeNode> queue = new LinkedList<>();

    public void addToQueue(TreeNode root) {
        if (root == null) {
            return;
        }
        queue.add(root);
        addToQueue(root.left);
        addToQueue(root.right);
    }

    public void flatten(TreeNode root) {
        addToQueue(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            temp.right = queue.peek();
            temp.left = null;
        }
    }
}

/***
 * 이 문제는 트리를  오른쪽으로 붙여서 만드는 문제이다.
 *
 * 일단 flatten을 이용해서 addToQueue에 root를 가져다 둔다.
 * 그리고 queue에다가 root를 붙인다.
 * 그리고 root.left를 이용해서 왼쪽 수부터 queue에 넣고, root.right를 이용해서 오른쪽 수를 queue에 넣는다.
 * 이후 다시 flatten에 돌아와서 반복해준다.
 * 일단 temp에 queue.poll()로 가지고 오고, temp의 오른쪽에 queue.peek()으로 수를 넣어준다.
 * 그리고 왼쪽노드는 비워야하기 때문에 temp.left에는 null로 넣는다.
 */