/*
105. Construct Binary Tree from Preorder and Inorder Traversal

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.


Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Deque<Integer> preorderQueue = new ArrayDeque<>();
        for (int val : preorder) {
            preorderQueue.offer(val);
        }

        return build(preorderQueue, inorder);
    }

    private TreeNode build(Deque<Integer> preorder, int[] inorder) {
        if (inorder.length > 0) {
            int idx = indexOf(inorder, preorder.poll());
            TreeNode root = new TreeNode(inorder[idx]);

            root.left = build(preorder, Arrays.copyOfRange(inorder, 0, idx));
            root.right = build(preorder, Arrays.copyOfRange(inorder, idx + 1, inorder.length));

            return root;
        }
        return null;
    }

    private int indexOf(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}

/***
 * 이 문제는 preorder와 inorder를 줄테니 트리를 만들어오라는 문제이다.
 * 솔직히 정답을 더 많이 본 문제이다.
 *
 * 일단 아이디어자체가 있어야 풀 수 있는 문제이다.
 * preorder = [3, 9, 20, 15, 7]
 * inorder = [9, 3, 15, 20, 7]
 * 이렇게 있으면 일단 preorder에 나오는 첫 값은 root일것이다.
 * 그럼 [3]이 inorder에 어디에 있는지 확인 해보자.
 * index 1에 위치하고 있고 왼쪽에는 [9], 오른쪽에는 [15, 20, 7]이 있다,
 * 왼쪽은 왼쪽 트리를 알려주고 있고, 오른쪽은 오른쪽 트리를 알려주고 있다.
 * 다음으로 preorder를 한 칸 옮겨서 [9]를 확인해보자.
 * index 0에 위치하고 있고, 왼쪽과 오른쪽에 아무것도 없는걸로 보아. 자식노드가 없다는 것이다.
 * 그리고 [20]을 확인해보자.
 * index 3에 위치하고 있고, 왼쪽은[15], 오른쪽은 [7]이 위치하고 있다.
 * 이런식으로 tree를 만들어주면 되는것이다.
 * 코드를 한 번 보면 일단 preorder에 있는걸 deque를 이용해서 순차적으로 넣어준다.
 * 그리고 index를 가져오는 함수를 작성해놓을것이다.
 * 배열과 값이 주어졌을때, 그 값의 인덱스를 가져오는 함수이다.
 * 그리고 build라는 함수를 만들어줄것이다.
 * 일단 preorder의 값을 가지고 와서 inorder에서 인덱스가 무엇인지 찾는다.
 * 그리고 그 값을 root로 넣어준다.
 * 그리고 왼쪽, 오른쪽 값을 재귀적으로 찾아줄것이다.
 * 왼쪽은 inorder의 0에서부터 index가 있는 위치일것이고,
 * 오른쪽은 inorder의 index+1에서부터 길이 끝까지일것이다.
 */