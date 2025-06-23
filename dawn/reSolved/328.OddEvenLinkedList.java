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
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

/***
 * 이 문제는 홀수 짝수를 나눠서 홀수순서노드를 반환하고, 이어서 짝수 순서노드를 붙여서 반환하라는 문제이다.
 *
 * 일단 첫 시작은 홀수이기에 odd는 head로 설정하고, 짝수는 head.next로 설정하고 짝수의 시작점을 저장하기 위해 even을 바라보고 있도록한다.
 * 그리고 반복할건데, 일단 홀수의 다음은 짝수의 다음이 될거기에 odd.next는 even.next가 되도록한다.
 * 그리고 현재 odd를 옮겨줘야하기때문에 odd는 odd.next로 변경해준다.
 * even도 같다.
 * evev.next는 홀수다음에 나올거기에 odd.next로 해준다.
 * 현재 even을 옮겨줘야하기 때문에 even은 even.next로 변경해준다.
 * 최종적으로 odd가 끝나면 짝수의 시작점으로 연결시켜줘야하기 때문에 odd.next는 evenHead가 되도록한다.
 * 이후 head를 반환시키면 된다.
 */