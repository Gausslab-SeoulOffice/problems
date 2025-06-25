/*
2095. Delete the Middle Node of a Linked List

ou are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.

The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.

For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.

Example 1:
Input: head = [1,3,4,7,1,2,6]
Output: [1,3,4,1,2,6]
Explanation:
The above figure represents the given linked list. The indices of the nodes are written below.
Since n = 7, node 3 with value 7 is the middle node, which is marked in red.
We return the new list after removing this node.

Example 2:
Input: head = [1,2,3,4]
Output: [1,2,4]
Explanation:
The above figure represents the given linked list.
For n = 4, node 2 with value 3 is the middle node, which is marked in red.

Example 3:
Input: head = [2,1]
Output: [2]
Explanation:
The above figure represents the given linked list.
For n = 2, node 1 with value 1 is the middle node, which is marked in red.
Node 0 with value 2 is the only node remaining after removing node 1.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }
}

/***
 * 이 문제는 중간 노드를 삭제하고 반환하라는 문제이다.
 *
 * 일단 prev는 slow 이전 slow노드를 보는걸로, 삭제하기 전 노드를 가르킨다.
 * slow는 한칸씩 가는 것이고 fast는 두칸씩 가는걸로 slow는 삭제되는 중간 노드를 말한다.
 * 일단 while을 통해 중간까지 가게 된다.
 * 그 이후 중간까지 갔으면 삭제해야하는 노드를 slow가 있는 위치가 될것이고, 그러면 prev.next로 slow를 건너뛰로 slow.next로 연결시켜주면 slow노드가 자연스럽게 빠지게 된다.
 * 그 이후 처음부터 반환시켜주면 되기때문에 head를 반환시킨다.
 */