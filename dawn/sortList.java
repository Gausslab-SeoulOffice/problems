/*
148. Sort List

Given the head of a linked list, return the list after sorting it in ascending order.



Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]

Example 2:
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]

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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);

    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }

        result.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}

/***
 * 이 문제는 linked list를 정렬하라는 문제이다. 제약조건이 있다면 시간복잡도가 O(nlogn)이어야한다는 건데, 그럼 merge sort를 하라는거 같았다.
 *
 * 일단 두개의 부분으로 나눴다.
 * list를 절반으로 나눌 수 있는 부분, 그리고 그 리스트를 정렬해서 합칠 수 있는 부분이다.
 * ​
 * 일단 주어진 head가 없거나 한개라면 이미 정렬이 된 상태이기 때문에 head를 반환한다.
 * 그리고 절반으로 무조건 나눠야한다.
 * 이때 두개의 포인트로 나눌건데, 한개는 한칸씩 이동하는것이고, 한개는 두칸씩 이동하게 된다.
 * 그러면 두칸씩 이동하는게 끝까지 가게 되면, 한칸씩 이동하는 친구는 절반까지 갔다고 볼 수 있다.
 * 그러면 늦게 간 친구는 왼쪽, 빠르게간 친구는 오른쪽을 다시 확인하면 되는것이다.
 * 중간은 slow.next로 해주고, 뒤에는 연결된게 있으면 안되니까 slow.next는 null로 설정해둔다.
 * 늦게간친구는 처음부터 mid까지 빨리간 친구는 mid부터 끝까지 돌게 된다.
 * 절반 나누고, 정렬해서 합치고를 계속 하면 모두 정렬된 리스트가 나오게 된다.
 */