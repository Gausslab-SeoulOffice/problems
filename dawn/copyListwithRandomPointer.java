/*
138. Copy List with Random Pointer

A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.


Example 1:
Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

Example 2:
Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]

Example 3:
Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]
 */

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> hashmap = new HashMap<>();
        Node curr = head;

        while (curr != null) {
            hashmap.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;

        while (curr != null) {
            Node fake = hashmap.get(curr);
            fake.next = hashmap.get(curr.next);
            fake.random = hashmap.get(curr.random);
            curr = curr.next;
        }
        return hashmap.get(head);
    }
}

/***
 * 이 문제는 head Node를 주면 똑같이 Linked List를 만들라는 문제이다.
 * 특이한 점이 있다면 next도 있지만 random이라는 것도 있다는 점이다.
 *
 * 그래서 일단 Hashmap 한개를 선언해서 <Node, Node>를 담을 수 있게 만들어준다.
 * 그리고 현재 Node를 curr로 선언해준다.
 * 그리고 일단 hashmap에 그냥 노드를 담을 것이다. hashmap.put(curr, new Node(curr.val))이렇게 담으면 next와 random은 빈 값이 되고, 그냥 값만 들어간 node가 생성된다.
 * 그리고 다시 curr를 head로 가지고 와서 다시 next와 random값을 넣어줄것이다.
 * Node fake = hashmap.get(curr)로 가지고 와서 원본 노드의 next가 가리키는 노드의 복사본을 찾고, 현재 복사본의 next에 연결한다.
 * 그리고 random도 같은 방법으로 연결한다.
 * 이걸 다 돌리게 되면 원본 리스트의 head에 해당하는 복사본을 hashMap에서 찾아 반환한다.
 */