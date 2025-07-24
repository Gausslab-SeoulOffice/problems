/*
230. Kth Smallest Element in a BST

Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.


Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
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
    List<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        return list.get(k - 1);
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}

/***
 * 이 문제는 트리에서 k번째로 작은 수를 구하는 문제이다.
 *
 * 트리 자체는 inOrder방식으로 구성되어 있고, 들어오는 root의 순서를 사용해서 inOrder로 탐색해서 list에 넣어야한다.
 * 일단 list를 만들어준다.
 * 그리고 inOrder함수를 이용해서 root를 보내준다.
 * root가 null이면 return한다.
 * 그게 아니라면 자식 노드가 있는것이기에 inOrder를 사용해서 왼쪽으로 계속 내려가게 된다.
 * 그리고 제일 끝까지 간다음에 list에 현재 값을 넣어준다.
 * 그리고 right를 사용해서 내려가준다.
 * 그렇게 되면 inOrder순서대로 list에 숫자가 추가 되는데, 오름차순으로 정렬되게 된다.
 * 마지막으로 k번째로 작은 수를 찾으려면 0부터 시작하기 때문에 list에서 k-1번째를 반환하면 된다.
 */