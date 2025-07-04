# 벡준 20440 - 🎵니가 싫어 싫어 너무 싫어 싫어 오지 마 내게 찝쩍대지마🎵 - 1
# https://www.acmicpc.net/problem/20440
# 딕셔너리를 활용해서 최대 구간을 찾기 (인덱싱에 주의)

import sys
from collections import defaultdict
input = sys.stdin.readline

# 입력부 (딕셔너리를 이용해서 도수 파악)
n = int(input())
timeline = defaultdict(int)
for i in range(n):
    start, end = map(int, input().split())
    timeline[start] += 1
    timeline[end] -= 1

max_overlap = 0                           # 최대 겹침 개수
cur_overlap = 0                           # 현재 시점에서의 겹침 개수
max_start = 0                             # 최대 겹침이 시작되는 시점
max_end = 0                               # 최대 겹침이 끝나는 시점
recording = False                         # 최대 구간 기록 중 여부

for t in sorted(timeline.keys()):
    cur_overlap += timeline[t]

    # 최대 겹침 개수 갱신
    if cur_overlap > max_overlap:
        max_overlap = cur_overlap         # 개수 갱신
        max_start = t                     # 시작 시점 갱신
        recording = True                  # '여기는 최대 구간에 포함됨'
    
    # 최대 겹침 구간이 종료되는 지점 찾기
    # 1) cur_overlap이 최대 겹침보다 작아졌다면, 겹치는 구간이 끝났을 수 있음
    # 2) 이번 시점의 변화량을 되돌려봤을 때, 직전이 최대 겹침 상태였는지 확인함
    # 3) 방금 최대 겹침이 시작된 경우인지 확인함
    elif cur_overlap < max_overlap and cur_overlap - timeline[t] == max_overlap and recording:
        max_end = t                       # 시점의 끝으로 저장
        recording = False                 # '여기는 최대 구간에 포함되지 않음'

        
print(max_overlap)
print(max_start, max_end)
