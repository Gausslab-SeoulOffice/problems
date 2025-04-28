/*
92. Reverse Linked List II

Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.


Example 1:
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

Example 2:
Input: head = [5], left = 1, right = 1
Output: [5]
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode prev = result;

        if (head == null || left == right) {
            return head;
        }

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;

        for (int i = 0; i < right - left; i++) {
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        return result.next;
    }
}

/***
 * 이 문제는 LinkedList에서 left, right를 주어지면 거기서 순서를 바꾸라는 문제이다.
 *
 * 일단 result를 0으로 초기화 시켜서 만들어놓는다.
 * 그리고 result.next는 head를 보고 있고, prev는 result를 보고 있다.
 * head가 null이거나 right와 left가 같으면 그냥 head를 반환한다.
 * 변경되는 노드 전까지 prev를 이동시켜놓는다.
 * 그리고 변경되야 하는 노드를 바라보는걸 curr로 선언한다.
 * temp를 사용해서 rigth-left 만큼 반복문을 돌려 노드를 변경해준다.
 * 이후 result를 반환하는데 맨 앞을 0으로 해놔서 result.next를 반환한다.
 */