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
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}

/***
 * 이 문제는 삭제하고 싶은 타켓을 가지고 그걸 삭제 한 후에 BST를 잃지 않게 만들어서 트리를 반환하는 문제이다.
 *
 * 일단 root가 null이면 null을 반환한다.
 * 여기서 할 수 있는게 세가지이다.
 * 내가 찾으려는 값과 같은 경우, 내 값이 더 큰 경우, 내 값이 더 작은 경우이다.
 * 내 값이 더 큰 경우엔, 왼쪽에서 찾으면 된다. 반대의 경우 오른쪽에서 찾으면 된다.
 * 중요한것은 값을 찾은 경우이다.
 * 리프노드가 둘 다 남은 경우, 오른쪽 서브트리에서 가장 작은 값 (inorder successor) 을 찾아 현재 노드의 값으로 복사한 후 중복된 그 값을 오른쪽 서브트리에서 다시 삭제한다.
 * 노드가 왼쪽 자식이 없으면 → 오른쪽 자식을 위로 올린다.
 * 노드가 오른쪽 자식이 없으면 → 왼쪽 자식을 위로 올린다.
 */