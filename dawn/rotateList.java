/*
61. Rotate List

Given the head of a linked list, rotate the list to the right by k places.


Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:
Input: head = [0,1,2], k = 4
Output: [2,0,1]
 */

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 1;
        ListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        temp.next = head;
        k = k % length;
        k = length - k;

        while (k-- > 0) {
            temp = temp.next;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }
}

/***
 * 이 문제는 k 만큼 뒤에 있는걸 앞으로 빼서 출력하라는 문제이다.
 *
 * 일단 head가 null이거나 head.next가 null이거나 k가 0 이면 그냥 head를 반환하면 된다.
 *
 * 그리고 이제 연결된 리스트 처럼 생각하고 문제를 풀 예정이다.
 * 전체 길이를 length로 구한다.
 * 그리고 temp는 마지막 노드를 가리키게 된다.
 * 그리고 temp.next르 head를 보게 하면 연결된다.
 * 회전 수가 너무 큰 경우를 대비해 k % length로 나머지만 사용한다.
 * 그리고 length - k 만큼 이동해서 새로운 head 직전의 노드를 찾을 것이다.
 * 왜냐면 오른쪽으로 k번 회전하는 건 왼쪽에서 length - k번 자르는 것과 같기 때문이다.
 * temp를 length - k번 앞으로 이동해서 끊을 지점 바로 전 노드로 간다.
 * temp.next를 null로 하면 원형을 다시 끊어서 일반 리스트로 되돌리는것이다.
 */