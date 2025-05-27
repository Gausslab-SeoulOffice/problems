/*
206. Reverse Linked List

Given the head of a singly linked list, reverse the list, and return the reversed list.



Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:
Input: head = []
Output: []
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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

/***
 * 이 문제는 LinkedList를 뒤집어서 반환하라는 문제이다.
 *
 * 그렇다면 이전에 있던걸 현재거에서 연결을 시켜야한다는 말이다.
 * 그 전 노드를 prev로 기억할 것이다.
 * 현재 노드는 curr로 기억할것이다.
 * 끝날때까지 반복할 예정인데, 일단 원래 내가 바라보는 노드에서 그 다음걸 next라고 하고 기억해놓는다.
 * 그리고 지금 있는 노드에서 이전노드랑 연결 시켜야하기때문에 curr.next=prev로 연결한다.
 *  prev는 이제 다음 노드인 현재노드를 가르켜야하기때문에 prev = curr로 옮겨진다.
 * 그리고 현재 보는 노드는 다음 노드를 봐야하기때문에 맨처음에 저장해놓은 next 노드로 옮겨진다.
 * 이렇게 하면 prev는 제일 마지막 노드를 가르키기 때문에 prev를 반환한다.
 */