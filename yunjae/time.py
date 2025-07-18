# 백준 18312 - 시각
# https://www.acmicpc.net/problem/18312

# 집계를 반복문 돌리며 count += 1 같은 식으로 하는데 sum(boolean for _ in range(...)) 같은 식으로도 할 수 있어 연습해봤습니다

n, k = map(int, input().split())
k = str(k)
print(sum(k in f"{h:02}{m:02}{s:02}" for h in range(n+1) for m in range(60) for s in range(60)))
