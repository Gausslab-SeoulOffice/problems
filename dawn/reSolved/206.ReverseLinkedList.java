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
 * 이 문제는 LinkedList를 뒤집는 문제이다.
 *
 * 일단 화살표를 뒤집는다고 생각하면 좀 더 쉽다.
 * 이전 값을 prev라고 생각하고, 현재 값은 curr이다.
 * 이전 값이 맨 처음에는 없으니까 null로 하고 현재 값은 head를 바라보게 한다.
 * 반복문을 돌리면서 next값이 변경이 되기때문에 미리 저장해두어야한다.
 * 현재 값에서 다음 값을 일단 저장시켜둔다.
 * 그리고 현재 값에서 다음값은 이전 값으로 해야한다.
 * 그리고 prev를 curr로 업데이트 시켜준다.
 * curr도 미리 저장해둔 next로 업데이트 시켜준다.
 * 그러면 next는 2가 되고, curr.next는 null, prev는 1, curr는 2가 된다.
 * 그 다음은 next는 3이 되고, curr.next는 null<-1, prev는 2, curr는 3이 된다.
 * 그 다음은 next는 4가 되고, curr.next는 null<-1<-2, prev는 3, curr는 4가 된다.
 * 이런식으로 prev에 쌓이게 되기 때문에 마지막으로 prev를 반환하면 된다.
 */