/*
19. Remove Nth Node From End of List

Given the head of a linked list, remove the nth node from the end of the list and return its head.


Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0, head);
        ListNode dummy = node;

        for(int i =0 ;i< n; i++){
            head = head.next;
        }

        while(head != null){
            head = head.next;
            dummy = dummy.next;
        }
        dummy.next = dummy.next.next;

        return node.next;
    }
}

/***
 * 이 문제는 뒤에서 n번째 노드를 삭제 시키는 문제이다.
 * 풀이 방법은 포인터를 두개 사용해서 한개는 그냥 끝까지 가고, 한개는 삭제 바로 직전노드까지 간 이후에, 삭제할 노드를 건너뛰고 그 다음 노드로 이동하려는 방법이다.
 *
 * 일단 처음부터 끝까지 갈 node를 선언한다. 근데 head가 null일 수 있으니까 0을 앞에 붙여서 선언해준다.
 * 그리고 삭제할거 바로 앞까지 가는 포인터를 dummy로 선언한다.
 * 그리고 head한테 n만큼 먼저 가있으라고 한다.
 * 그리고 head랑 dummy랑 같이 이동하게된다. 끝까지 가면 dummy는 자연스럽게 삭제될거 바로 뒤에 위치한다.
 * 그 이후에 dummy.next를 건너뛰어서 dummy.next.next로 연결시켜준다.
 * 그리고 node.next를 반환하면 된다.
 */