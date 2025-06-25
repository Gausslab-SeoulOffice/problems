/*
1448. Count Good Nodes in Binary Tree

Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.


Example 1:
Input: root = [3,1,4,3,null,1,5]
Output: 4
Explanation: Nodes in blue are good.
Root Node (3) is always a good node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.

Example 2:
Input: root = [3,3,null,4,2]
Output: 3
Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.

Example 3:
Input: root = [1]
Output: 1
Explanation: Root is considered as good.
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
    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        return goodNodes(root, max);
    }

    private int goodNodes(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int result = root.val >= max ? 1 : 0;
        result += goodNodes(root.left, Math.max(max, root.val));
        result += goodNodes(root.right, Math.max(max, root.val));
        return result;
    }
}

/***
 * 이 문제는 지금 있는 노드의 깊이 위치에서 가장 수가 큰걸 찾아야하고, 그 갯수를 저장해서 반환하는 문제이다.
 *
 * 일단 가장 큰 수를 체크해야하기때문에 max를 선언한다.
 * 그리고 함수를 한개 만든다.
 * root가 null이라면 0을 반환한다.
 * result는 0인지 1인지 확인하는건데, 지금 값이 max보다 더 크거나 같으면 1로 추가할 수를 말해주는것이다.
 * max보다 작으면 0으로 할것이다.
 * result는 goodNodes를 재귀로 계속 반복되면서 왼쪽 노드와 max를 계산해서 result에 계속 추가한다.
 * 또 goodNodes를 재귀로 반복하면서 오른쪽 노드와 max를 계산해서 result에 계속 추가한다.
 * 이후 result를 반환하면 된다.
 */