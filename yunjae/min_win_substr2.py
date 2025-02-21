# LeetCode 76. Minimum Window Substring 재도전 후 제출 성공 버전

# 시간복잡도상, 이 문제는 출제자가 의도한 풀이가 정해져 있다.
# frequency table을 쓰는 것.

# s에 적힌 글자를 하나씩 freq_table에서 찾아, 집계수를 줄여 나간다.
# 한 window 안에서 모든 캐릭터를 훑고, 
# 그 window를 쓸모없어질 때까지 줄여나가는 과정에서 freq_table의 수를 원래대로 돌려놓는다.

# Counter(t)는 도수분포표다. key로 접근하면 그 글자의 집계수를 반환한다.
# 다만 도수분포표와 차이가 있다면, value에 음수가 들어갈 수도 있다는 것.
# 이를 이용해서 t에 포함된 글자냐 아니냐를 걸러내도록 하자.

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if not s or not t:
            return ""

        freq_table = Counter(t)
        req_chars = len(t)

        min_len = float('inf') # 이거 생각해내서 쓰는 연습을 좀 많이 하자
        l, r = 0, 0
        min_l, min_r = 0, 0

        while r < len(s):
            if freq_table[s[r]] > 0: # t에 포함된 글자라면 
                req_chars -= 1       # t의 글자수를 하나 빼준다
            freq_table[s[r]] -= 1   # t에 없는 글자의 개수는 음수로 집계된다
            r += 1

            # 한 턴에서, t에 포함된 모든 글자를 s에서 다 훑었다면
            # 그때의 l~r 구간을 window로 삼아 min_l, min_r 을 업데이트
            while req_chars == 0:
                if r - l < min_len:
                    min_len = r - l
                    min_l, min_r = l, r

                # window를 점점 줄여나갈 차례다. 
                freq_table[s[l]] += 1       # 이미 훑은 글자를 훑기 전으로 복원한다
                if freq_table[s[l]] > 0:    # t에 있는 글자라면, 복원 결과 양수로 집계될 테니 이걸 이용해서 루프 탈출하겠다.
                    req_chars += 1 # 이 시점에서 본 window는 더 이상 쓸모가 없다. 루프 탈출
                l += 1 # 아직 window가 쓸모가 있다면, 계속 window의 폭을 줄여보자
  
        return s[min_l:min_r] if min_len != float('inf') else ""  # 이런 식의 조건문은 읽기에 복잡하지만 Pythonic해서 나는 선호한다
