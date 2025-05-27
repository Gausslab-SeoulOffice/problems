/*
328. Odd Even Linked List

Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.


Example 1:
Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]

Example 2:
Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

/***
 * 이 문제는 인덱스를 확인해서 홀수 인덱스인 리스트를 연결하고 그 뒤에 짝수 인덱스인 노드를 연결해서 반환하라는 문제이다.
 *
 * 일단 head가 비어있으면 null을 반환한다.
 * 그리고 홀수와 짝수 노드를 각각 가지고 있기 위해서 odd, even ListNode를 만들어준다.
 * 짝수노드의 시작점을 알기 위해 evenHead를 선언해준다.
 * 그리고 끝까지 갈건데, 일단 홀수 다음엔 짝수가 와야하기 때문에 odd.next = even.next를 해준다.
 * 그리고 홀수의포인터를 다음 홀수 인덱스로 옮겨주기 위해 odd = odd.next를 해준다.
 * 짝수도 마찬가지이다.
 * 짝수 다음엔 홀수가 와야하기 때문에 even.next = even.next.next를 해준다.
 * 그리고 짝수의 포인터를 다음 짝수 인덱스로 옮겨주기 위해 even = even.next를 해준다.
 * 이후 홀수 다음에 짝수포인터의 맨처음이 옮겨지면 된다.
 */