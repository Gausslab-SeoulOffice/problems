# 백준 7453 - 합이 0인 네 정수
# https://www.acmicpc.net/submit/7453/95895934
# 원래는 투포인터 문제로 자주 출제되지만, 좀더 직관적인 해싱을 사용한 풀이부터.
# (시간복잡도 면에서 좋은 풀이는 아닙니다)

import sys
from collections import Counter
input = sys.stdin.readline

n = int(input())
a, b, c, d = [], [], [], []

for _ in range(n):
    x1, x2, x3, x4 = map(int, input().split())
    a.append(x1)
    b.append(x2)
    c.append(x3)
    d.append(x4)

# 가능한 모든 A+B와 C+D를 미리 계산해 두기
ab, cd = [i + j for i in a for j in b], [i + j for i in c for j in d]

# C+D 리스트 안의 각 합에 대해, 등장 횟수 저장
# 예) cd = [3, -1, -1, 2]면 Counter(cd) = {3:1, -1:2, 2:1}
cd = Counter(cd)

# 이 둘의 합이 0이 되는 경우의 수를 찾아 개수 파악
cnt = 0
for i in ab:
    cnt += cd[-i]

print(cnt)
