/*
141. Linked List Cycle

Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.



Example 1:
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Example 2:
Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Example 3:
Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while (first != null && first.next != null) {
            first = first.next.next;
            second = second.next;
            if (first == second) {
                return true;
            }
        }
        return false;
    }
}

/***
 * 이 문제는 Linked list가 순환되는지 묻는 문제이다.
 *
 * 해결 방법은 생각보다 쉽다.
 * 한명은 빠르게 달린다고 생각하고, 한명은 정박으로 달린다고 생각한다.
 * 빠르게 달리는 얘가 null이 아닐때 까지 달릴때 연결이 되어 있으면 언젠간 같은 수에 머무르게 된다.
 * 빠르게 달리는 걸 first로 선언하고, 정박으로 달리는 걸 second로 선언한다.
 * first가 null이 아니고 first.next가 null이 아닐때 까지 first는 fisrt.next.next로 두번을 건너뛰고, second는 second.next로 한칸씩 건너뛰게 된다. 이 과정에서 만약 first랑 second가 같으면 이 Linked List는 순환한다.
 * 이를 결과로 return하면 된다.
 */