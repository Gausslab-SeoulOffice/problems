/*
86. Partition List

Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.


Example 1:
Input: head = [1,4,3,2,5,2], x = 3
Output: [1,2,2,4,3,5]

Example 2:
Input: head = [2,1], x = 2
Output: [1,2]
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
    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);

        ListNode before = beforeHead;
        ListNode after = afterHead;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = afterHead.next;

        return beforeHead.next;
    }
}

/***
 * 이 문제는 x를 기준으로 큰수는 큰수대로 작은 수는 작은수대로 순서는 변경하지 않고 그대로 붙이라는 의미이다.
 *
 * 일단 앞을 저장할 before, after를 만들어준다. 그 전에 시작 더미 노드인 beforeHead, afterHead를 선언해준다.
 * 그리고 head가 null이 아니면 계속 반복할것이다.
 * 지금 숫자가 x보다 작으면 before에 넣어줘야한다.
 * before.next = head;   // before 리스트 뒤에 head 붙이기
 * before = before.next; // 붙인 노드를 새 끝점으로 이동
 * 지금 숫자가 x보다 크거나 같으면 after에 넣어줘야한다.
 * 그리고 끝나면 after.next를 비게 해준다.
 * before과 after를 연결해야하기에 before.next = afterHead.next를 보게 한다.
 * 그리고 beforeHead.next를 반환하면 된다.
 */