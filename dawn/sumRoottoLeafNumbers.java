/*
129. Sum Root to Leaf Numbers

You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.


Example 1:
Input: root = [1,2,3]
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.

Example 2:
Input: root = [4,9,0,5,1]
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
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
    int result = 0;

    private void sumNode(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            result += (sum * 10 + root.val);
            return;
        }
        sumNode(root.left, sum * 10 + root.val);
        sumNode(root.right, sum * 10 + root.val);
    }

    public int sumNumbers(TreeNode root) {
        sumNode(root, 0);
        return result;
    }

}

/***
 * 이 문제는 leaf node까지 숫자를 만들어서 각각 숫자들을 합한 값이 무엇인지 묻는 문제이다.
 *
 * 일단 모든 값을 더할 result를 선언하고, 각 숫자들을 만들고 더해줄 함수를 선언한다.
 * root.left와 root.right가 둘 다 null이면 leaf노드가 없다는 것이기에, 마지막 leaf노드라는 것이다.
 * 그런 경우는 result에 지금 가지고 있는 sum*10으로 자리수를 높여주고 지금 값을 + 해서넣어준다.
 * 그리고 leaf노드가 남은 경우는 그걸 끝까지 검사해야하기 때문에 재귀로 넘겨서 다시 검사한다.
 * 검사 대상은 root.left와 root.right가 된다.
 * 이 모든걸 끝내면 result에 값이 다 더해져서 나오는걸 확인할 수 있다.
 */