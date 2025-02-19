# 백준 2559: 수열
# 만약 slicing을 하면 시간초과가 뜬다. 따라서 슬라이딩 윈도우로 푼다.

m, n = map(int, input().split())
temps = list(map(int, input().split()))

window = sum(temps[0:n])
answer = window

for i in range(n, m):
    window += temps[i] - temps[i-n]
    answer = max(window, answer)

print(answer)
