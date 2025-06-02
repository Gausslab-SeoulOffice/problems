/*
1161. Maximum Level Sum of a Binary Tree

Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level x such that the sum of all the values of nodes at level x is maximal.


Example 1:
Input: root = [1,7,0,7,-8,null,null]
Output: 2
Explanation:
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.

Example 2:
Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
Output: 2
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
    public int maxLevelSum(TreeNode root) {
        List<Integer> levelSumList = new ArrayList<>();
        dfs(root, levelSumList, 0);

        int maxLevel = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < levelSumList.size(); i++) {
            if (levelSumList.get(i) > maxSum) {
                maxSum = levelSumList.get(i);
                maxLevel = i + 1;
            }
        }
        return maxLevel;
    }

    private void dfs(TreeNode root, List<Integer> list, int depth) {
        if (root == null) {
            return;
        }
        if (depth == list.size()) {
            list.add(root.val);
        } else {
            list.set(depth, list.get(depth) + root.val);
        }
        dfs(root.left, list, depth + 1);
        dfs(root.right, list, depth + 1);
    }
}

/***
 * 이 문제는 같은 레벨에 있는 노드들의 합을 구해서 가장 큰 값을 가지고 있는 depth를 반환하는 문제이다.
 *
 * 일단 함수느 두개로 구성된다.
 * dfs로 구할 예정이기에 그 레벨에 있는 합을 넣어놓을 list를 선언한다.
 * 그리고 제일 큰 합을 가지고 있는 level을 maxLevel로 선언한다.
 * 그 제일 큰 합을 maxSum으로 선언한다.
 * dfs(root, result, 0)으로 맨 처음 보낸다.
 * dfs를 다 돌리고 나면 result에 각 level에서의 합들이 저장되어 있을테니 그걸 가지고, 가장 큰 값을 찾고, 그 값이 들어가 있는 level은 인덱스+1이 될것이다.
 * dfs함수는 같은 깊이에 있는 수를 더해서 저장하는 역할을 한다.
 * depth와 list.size()가 같은 경우는 그 depth에서 처음으로 나온 노드라는것을 의미한다.
 * 그러면 바로 List에 추가를 해주면되고, 그게 아니라면 같은 depth에 이미 있는 수에 합해서 넣어줘야하기 때문에, list.set을 이용해서 값을 변경해줘야한다.
 * 이후 재귀를 이용해서 돌려주면 된다.
 */