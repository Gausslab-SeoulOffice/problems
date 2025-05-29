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
 * 이 문제는 내가 속한 라인 위쪽에서 내가 가장 큰수이거나 큰수랑 같은수의 갯수를 증가시켜서 반환하는 것이다.
 *
 * 일단 숫자를 가장 작은 수로 선언해둔다.
 * 그리고 확인을 해야한다.
 * root가 null이면 0을 리턴한다.
 * 그게 아니라면 노드가 있는 것이기때문에 확인한다.
 * 현재 가지고 있는 가장 큰 수와 지금 나의 노드를 확인해서 내가 가장 크면 result에 1을 넣어준다.
 * 그리고 result를 업데이트 시켜줄것이다.
 * 왼쪽 트리, 오른쪽 트리를 계속 확장시키면서 result 값을 더해준다.
 * 이후 모든게 끝나면 result값을 반환하면 된다.
 */