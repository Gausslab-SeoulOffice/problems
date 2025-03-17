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
 * 이 문제는 모든 수를 오른쪽 노드로 옮기라는 문제이다.
 *
 * 일단 LinkedList 기반의 Queue를 한 개 선언한다.
 * 여기에 숫자를 넣어서 나중에 right쪽으로 peek()할 예정이다.
 * 그리고 addToSum이라는 함수를 한 개 구현한다.
 * 이건 TreeNode 한개를 인자로 받고, root가 null이라면 return;을 하고,
 * 그게 아니라면 queue에 add를 한다.
 * 그리고 재귀로 root.left, root.right를 돌리게 된다.
 * 이러면 모든 숫자가 다 들어가게된다,
 * 그리고 이 queue가 들어가 있으면 temp라는 TreeNode를 만들어서 할당하고, temp.right에 queue에 있는 숫자를 peek()해서 넣어준다. 그리고 left에는 null을 넣어준다.
 */