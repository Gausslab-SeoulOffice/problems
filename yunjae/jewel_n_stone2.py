# LeetCode 771: Jewels and Stones
# defaultdict 자료형을 이용한 풀이입니다.
# 존재하지 않는 키에 대해서는 default를 리턴하기 때문에, 예외처리를 위한 코드를 쓰지 않아도 돼서 간편합니다.

import collections

class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        freqs = collections.defaultdict(int)
        count = 0

        # 돌의 빈도 수 계산
        # 이렇게 하면 글자를 한 자씩 순회하면서 딕셔너리에 추가한다
        for char in stones:
	        freqs[char] += 1

        # 비교 없이 보석 속 글자의 빈도수만큼 count에 기록함
        for char in jewels:
            count += freqs[char]

        return count
