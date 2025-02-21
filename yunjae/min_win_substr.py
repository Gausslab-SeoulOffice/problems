# LeetCode 76 - Minimum Window Substring

from collections import Counter

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        m, n = len(s), len(t)
        l, r = 0, 1
        ans = ''

        while True:
            if len(t) > len(s):
                break
            elif Counter(t) & Counter(s[l:r]) == Counter(t):
                if len(ans) == 0 or len(s[l:r]) < len(ans):
                    ans = s[l:r]
                l += 1
                if l == len(s):
                    break
            else:
                if r <= len(s):
                    r += 1
                    if r > len(s):
                        break
    
        return ans

# 이 코드로는 대부분의 test case를 통과할 수 있지만,
# 고의적으로 엄청나게 긴 문자열을 s와 t에 할당할 경우 Counter 집계와 비교 과정에서 시간초과가 뜹니다.
# 우선 제출하고 나머지 하루는 이 문제의 최적화 방법을 고민해 보겠습니다.
