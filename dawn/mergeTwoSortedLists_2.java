/*
21. Merge Two Sorted Lists

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.


Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr = new ListNode();
        ListNode result = curr;
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                curr.next = list2;
                list2 = list2.next;
            } else {
                curr.next = list1;
                list1 = list1.next;
            }
            curr = curr.next;
        }
        if (list1 == null) {
            curr.next = list2;
        } else {
            curr.next = list1;
        }
        return result.next;
    }
}

/***
 * 이 문제는 두개의 Linked List를 주고 오름차순으로 한개의 Linked List를 반환하라는 문제이다.
 *
 * 일단 지금 숫자를 저장할 수 있는 curr라는 ListNode를 선언한다.
 * 이걸 바라보는 result라는 ListNode를 선언한다.
 * 그리고 list1이나 list2가 null이면 나머지걸 return한다.
 * 이제 둘 다 null이 아닐때 까지 돌건데, list1.val > list2.val이면 curr.next에다가는 작은 수인 list2가 들어가고 list2는 list2.next로 업데이트 시킨다.
 * 반대면 작은 수인 list1이 들어가고 list1은 list1.next로 업데이트 시킨다.
 * 그리고 curr은 curr.next로 업데이트 시킨 후 반복문을 돌린다.
 * 반복문을 다 돌린 후에 list가 null이 아니라면 뒤에 붙여준다.
 * 그리고 curr은 0 부터 시작할테니 result.next를 return 하면 된다.
 */