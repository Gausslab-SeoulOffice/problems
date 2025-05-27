/*
2095. Delete the Middle Node of a Linked List

You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.

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
        ListNode prev = new ListNode(0);
        prev.next = head;
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
 * 이 문제는 가운데에 있는 노드를 제거하고 반환하는 문제이다.
 *
 * 일단 head가 없거나 한개만 있으면 null를 반환한다.
 * 그리고 이제 순차적으로 넣기위해 prev를 한개 선언해준다.
 * 그리고 slow와 fast를 선언한다.
 * 가운데에 있는걸 없애야하기때문에 fast는 두칸씩 뛰고, slow는 한칸씩 뛴다.
 * fast가 끝나면 slow는 가운데에 있는 제거할 노드를 가르키고 있다.
 * prev는 slow를 바라보고 있고, 제거할 노드까지 가면 while문은 그만 돌리게 된다.
 * 그러면 prev.next자리에 slow를 건너뛰고 slow.next를 넣으면 제거할 노드를 건너뛰고 들어가게 된다.
 * 이후 노드가 제거된거기때문에 head를 출력해준다.
 */