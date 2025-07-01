/*
450. Delete Node in a BST

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.


Example 1:
Input: root = [5,3,6,2,4,null,7], key = 3
Output: [5,4,6,2,null,null,7]
Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.

Example 2:
Input: root = [5,3,6,2,4,null,7], key = 0
Output: [5,3,6,2,4,null,7]
Explanation: The tree does not contain a node with value = 0.

Example 3:
Input: root = [], key = 0
Output: []
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode minTree = minTree(root.right);
            root.val = minTree.val;
            root.right = deleteNode(root.right, minTree.val);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode minTree(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}

/***
 * 이 문제는 key라는 노드를 삭제하는 문제이다.
 * 그리고 그 자리에는 트리가 연결되서 들어야가야한다.
 *
 * 일단 BST이기 때문에 그걸 지켜야한다.
 * 지금 있는 위치가 key 값과 같은 경우, 더 큰 경우, 더 작은 경우로 나눈다.
 * 만약 더 크다면 왼쪽을 살펴야하기 때문에 root.left에 deleteNode로 다시 살피면 된다.
 * 더 작다면 오른쪽을 살펴야하기 때문에 root.right에 deleteNode로 다시 살피면 된다.
 * 같다면 이제 leaf노드가 있는 경우 없는 경우로 나눠서 볼 수 있다.
 * 만약 left가 없다면 오른쪽을 반환하면 되고, right가 없다면 왼쪽을 반환하면 된다.
 * 둘 다 있으면 오른쪽 트리에서 가장 작은 노드를 자리로 옮겨주어야한다.
 * 가장 작은 노드를 찾은 함수를 minTree로 한다.
 * 그걸 찾아서 root.val자리로 옮겨주고, 오른쪽 트리에서 삭제해주면 된다.
 */