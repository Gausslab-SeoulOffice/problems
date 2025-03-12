/*
2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.


Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fake = new ListNode();
        ListNode result = fake;

        int total = 0;
        while (l1 != null || l2 != null || total > 0) {
            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }
            fake.next = new ListNode(total % 10);
            total /= 10;
            fake = fake.next;
        }
        return result.next;
    }
}

/***
 * 이 문제는 두개의 Linked list가 있고 두개를 덧셈해서 결과를 가지고 오는건데, 순서대로 가져오는거 아니고 맨 앞이 일의 자리수인 것이다.
 *
 * 그러니 일단 덧셈을 할 fake를 한개 ListNode로 선언해준다.
 * 그리고 실제 결과를 가져올 result 한 개를 선언한다.
 * 그 숫자의 덧셈을 위해 total를 선언한다.
 * 그리고 여기서 한 번 틀렸는데 total >0 이걸 넣어줘야 마지막에 10이 넘어갔을때 1까지 나올 수 있다.
 * 그리고 l1이 null이 아니면 total에다가 더해준다. 그리고 다음으로 넘기고, l2가 null이 아니면 total에다가 더해준다. 그리고 다음으로 넘긴다.
 * 10이 넘어가면 1의 자리수만 필요하기 때문에 fake에 total%10한 값을 넣어준다. 그리고 total은 10의 자리수를 남긴다. 그리고 fake를 다음으로 넘긴다.
 * 이걸 다 반복하면 fake는 0부터 시작하는 ListNode가 되기때문에 이를 바라보고 있는 result 노드는next부터 return하면 된다.
 */