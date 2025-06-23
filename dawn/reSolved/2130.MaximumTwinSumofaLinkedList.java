/*
2130. Maximum Twin Sum of a Linked List

In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.

For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
The twin sum is defined as the sum of a node and its twin.

Given the head of a linked list with even length, return the maximum twin sum of the linked list.


Example 1:
Input: head = [5,4,2,1]
Output: 6
Explanation:
Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
There are no other nodes with twins in the linked list.
Thus, the maximum twin sum of the linked list is 6.

Example 2:
Input: head = [4,2,2,3]
Output: 7
Explanation:
The nodes with twins present in this linked list are:
- Node 0 is the twin of node 3 having a twin sum of 4 + 3 = 7.
- Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.
Thus, the maximum twin sum of the linked list is max(7, 4) = 7.

Example 3:
Input: head = [1,100000]
Output: 100001
Explanation:
There is only one node with a twin in the linked list having twin sum of 1 + 100000 = 100001.
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
    public int pairSum(ListNode head) {
        int max = 0;
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            int sum = list.get(i) + list.get(list.size() - i - 1);
            max = Math.max(max, sum);
        }
        return max;
    }
}

/***
 * 이 문제는 데칼코마니처럼 쌍을 이뤄서 제일 큰 수를 반환하라는 문제이다.
 *
 * 일단 list를 이용하기로 했다.
 * LinkedList를 전부 돌아서 list에 넣고, 쌍을 맞춰서 더해서 가장 큰 수를 찾도록 했다.
 * 일단 list에 curr.val를 전부 넣어준다.
 * 그리고 절반만 돌리면 합이 완성되기 때문에 list.size()/2만큼만 돌려준다.
 * sum에 list.get(i)와 list.get(list.size()-i-1)을 더해준다.
 * 그리고 Math.max를 이용해서 가장 큰 수를 업데이트 해준다.
 * 이후 max를 반환하면 된다.
 */