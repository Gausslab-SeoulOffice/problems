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
        List<Integer> sumList = new ArrayList<>();
        dfs(root, sumList, 0);

        int max = Integer.MIN_VALUE;
        int maxLevel = 0;

        for (int i = 0; i < sumList.size(); i++) {
            if (sumList.get(i) > max) {
                max = sumList.get(i);
                maxLevel = i + 1;
            }
        }
        return maxLevel;
    }

    private void dfs(TreeNode root, List<Integer> sumList, int depth) {
        if (root == null) {
            return;
        }
        if (depth == sumList.size()) {
            sumList.add(root.val);
        } else {
            sumList.set(depth, sumList.get(depth) + root.val);
        }
        dfs(root.right, sumList, depth + 1);
        dfs(root.left, sumList, depth + 1);
    }
}

/***
 * 이 문제는 depth끼리 합을 구해서 제일 큰 합이 나타나는 level을 반환하라는 문제이다.
 *
 * 일단 depth별로 봐야하기 때문에 dfs라는 함수를 만들어두고, 진행한다.
 * dfs는 root가 null이라면 return한다
 * depth와 list.size()가 동일하면 값을 넣어야한다.
 * 근데 동일하다는게 처음 들어온 수를 의미하는거고, 같은 depth에 노드가 여러개 있을 수 있으니까 만약 추가가 된게 있고 그 이후 노드가 들어오게 된다면, 존재하는 list에 다시 값을 더해서 세팅을 해줘야한다.
 * 그런 경우에 sumList.set을 이용해서 값을 세팅해준다.
 * 그리고 오른쪽, 왼쪽노드를 다시 dfs로 탐색하면 된다.
 * 이게 끝나면 list에 값이 다 들어가 있다.
 * 그럼 여기서 가장 큰 수를 찾고, 그 수의 level을 찾아주면 된다.
 * level은 인덱스+1의 값이 된다.
 */