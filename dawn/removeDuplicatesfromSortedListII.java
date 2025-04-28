/*
82. Remove Duplicates from Sorted List II

Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.


Example 1:
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]

Example 2:
Input: head = [1,1,1,2,3]
Output: [2,3]
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode(0);
        result.next = head;

        if(head == null || head.next == null){
            return head;
        }

        ListNode curr = result;

        while(curr.next != null && curr.next.next != null){
            if(curr.next.val == curr.next.next.val) {
                int num = curr.next.val;
                while(curr.next != null && curr.next.val == num){
                    curr.next = curr.next.next;
                }
            }else{
                curr = curr.next;
            }
        }
        return result.next;
    }
}

/***
 * 이 문제는 중복된 노드가 있으면 그 노드는 건너뛰고 중복이 없는 노드들만 보여달라는 문제이다.
 *
 * 일단 result라는 ListNode를 선언하고 앞에 0으로 초기화 시켜준다.
 * 그리고 result는 head를 본다.
 * head가 null이거나 head.next가 null이면 그냥 head를 반환한다.
 * 그리고 현재 상황을 알고 있는 curr를 선언하고 이건 result를 보고 있다,
 * curr.next가 null이 아니고 curr.next.next가 null이 아닐때까지 반복문을 돌린다.
 * 만약 curr.next.val이 curr.next.next.val이랑 같으면 중복이 있다는거기에 일단 그 값을 num으로 받는다.
 * 그리고 더 반복되는게 있는지 확인하기 위해 curr.next.val이 null이 아니고 curr.next.val이 num이랑 같으면 쭉쭉 넘기게 된다.
 * 반복되는게 없으면 curr = curr.next로 바로 넘어간다.
 * 이후 반복문을 다 돌린후에 result를 반환해야하는데 맨 앞을 0으로 해놨으니 result.next를 반환한다.
 */