/*
199. Binary Tree Right Side View

Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.


Example 1:
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
Explanation:

Example 2:
Input: root = [1,2,3,4,null,null,null,5]
Output: [1,3,4,5]
Explanation:

Example 3:
Input: root = [1,null,3]
Output: [1,3]

Example 4:
Input: root = []
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    private void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
    }
}

/***
 * 이 문제는 이진 트리의 오른쪽에서 보이는 노드들을 리스트로 반환하는 문제이다.
 *
 * 오른쪽부터 방문하는게 핵심이다.
 * 트리를 탐색할건데 그 깊이에서 처음 방문하는걸 List에 넣는거다.
 * 오른쪽부터 시작하기때문에, 제일 먼저 방문하는건 제일 오른쪽이 될 예정이다.
 * 그게 끝나면 왼쪽 트리로 가는데, 그 깊이에 숫자가 없으면 오른쪽트리에 값이 없던 것이기 때문에 왼쪽노드가 들어가게 된다.
 */