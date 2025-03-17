/*
117. Populating Next Right Pointers in Each Node II

Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.


Example 1:
Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.

Example 2:
Input: root = []
Output: []
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                if (i < size - 1) {
                    curr.next = queue.peek();
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
        return root;
    }
}

/***
 * 이 문제는 같은 레벨에서 맨 오른쪽 노드 다음엔 null을 넣고 싶은 문제이다.
 *
 * 각 node에 특이한 값이 next 라는게 있는데, 이건 같은 level에서 오른쪽에 있는 노드를 가리켜야한다.
 * 일단 root를 받아서 null이면 바로 반환한다.
 * 그리고 BFS를 하기 위해서 queue를 선언해서 queue에 root를 넣는다.
 * 그리고 queue가 빌때까지 반복하는데, 현재 queue에 있는 node개수를 저장하고, 그 개수만큼 반복할거다.
 * 노드를 한개씩 꺼낸다음에, i<size-1이면 아직 같은 레벨에서 마지막 노드가 아니라는 것이다.
 * 그러면 queue.peek()로 다음 노드를 next로 연결해 놓는다.
 * curr의 왼쪽 오른쪽 노드가 있으면 queue에 추가하게된다.
 * 만약 [1, 2, 3, 4, 5, 6, 7] 이 있다고 하면,
 * 1단계) queue = [1] -> size =1 이고, 1을 꺼내고 2,3을 queue에 추가한다.
 *             1.next = null, queue = [2, 3]이 된다.
 * 2단계) queue = [2, 3] -> size = 2 이고, 2를 꺼내고 3이랑 연결한다.
 *             2.next = 3
 *             3.next = null, queue = [4, 5, 6, 7] 이 된다.
 * 3단계) queue = [4, 5, 6, 7] -> size = 4이고
 *             4.next = 5
 *             5.next = 6
 *             6.next = 7
 *             7.next = null
 * 이렇게 된다.
 */