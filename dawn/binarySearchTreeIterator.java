/*
173. Binary Search Tree Iterator

Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
int next() Moves the pointer to the right, then returns the number at the pointer.
Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.

You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.



Example 1:


Input
["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
[[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
Output
[null, 3, 7, true, 9, true, 15, true, 20, false]

Explanation
BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
bSTIterator.next();    // return 3
bSTIterator.next();    // return 7
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 9
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 15
bSTIterator.hasNext(); // return True
bSTIterator.next();    // return 20
bSTIterator.hasNext(); // return False

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
class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null){
            stack.push(curr);
            if(curr.left != null){
                curr = curr.left;
            }else{
                break;
            }
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        TreeNode curr = node;
        if(curr.right != null){
            curr= curr.right;
            while(curr != null){
                stack.push(curr);
                if(curr.left != null){
                    curr = curr.left;
                }else {
                    break;
                }
            }
        }
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

/***
 * Inorder를 하는 걸 구현하는 것이다.
 *
 * BST에서는 왼쪽 → 루트 → 오른쪽 순서로 방문하면 오름차순 정렬된 값을 얻는것이다.
 * 스택에 왼쪽 끝까지 가면서 노드를 저장해둬야 한다.
 * stack.push(curr);  // 현재 노드를 스택에 저장한다.
 * curr = curr.left;  // 왼쪽으로 이동 (왼쪽이 제일 작은 값이니까!)
 * next함수를 보면
 * TreeNode node = stack.pop(); // 스택에서 가장 위에 있는(가장 작은) 노드 꺼냄
 * if (curr.right != null) {  // 오른쪽 자식이 있다면
 *         curr = curr.right;
 *         while (curr != null) {  // 그 오른쪽 자식의 왼쪽 끝까지 가면서 스택에 추가
 *             stack.push(curr);
 *             curr = curr.left;
 *         }
 *     }
 *     return node.val;  // 현재 노드의 값 반환
 *
 * BSTIterator iterator = new BSTIterator(root);  // [7, 3] (초기 스택)
 * iterator.next();  // 3 반환, 스택 상태: [7]
 * iterator.next();  // 7 반환, 15의 왼쪽 끝인 9을 추가 -> [15, 9]
 * iterator.next();  // 9 반환, 스택 상태: [15]
 * iterator.next();  // 15 반환, 20 추가 -> [20]
 * iterator.next();  // 20 반환, 스택 상태: []
 *
 * hasNext()함수의 경우 return !stack.isEmpty(); // 스택이 비어있지 않으면 true
 */