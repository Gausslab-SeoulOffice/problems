# LeetCode: 두 수의 덧셈
# https://leetcode.com/problems/add-two-numbers/description/
# 전가산기를 이용한 풀이 (전가산기는 원래 이진 연산을 활용하지만 여기서는 구조만 차용해서 십진수 연산)
# 입력값: A, B, 이전의 자리올림수(carry-in, 처음은 0으로 설정)
# 출력값: 합(sum: A xor B xor C = AB'C' + A'BC' + A'B'C), 다음의 자리올림수(carry-out, 즉 몫: AB + AC + BC)

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        root = head = ListNode(0)  # 결과 리스트의 시작점 dummy node
        carry = 0  # 자리올림수를 저장
        while l1 or l2 or carry:
            sum = 0
            if l1:
                sum += l1.val  # A
                l1 = l1.next
            if l2:
                sum += l2.val  # B
                l2 = l2.next
		
            # 몫과 나머지 계산하여 tuple unpacking: (a // b, a % b)
            # 몫: carry-out. 다음 연산에 활용
            # 나머지: 값으로 취한다
            carry, val = divmod(sum + carry, 10)
            
            # 결과 리스트를 구성
            head.next = ListNode(val)
            head = head.next  # 새로 추가한 노드를 현재 포인트로 삼는다
            
        return root.next # dummy를 제외한 결과 linked list 반환
