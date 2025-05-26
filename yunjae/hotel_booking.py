# 프로그래머스: 호텔 대실
# https://school.programmers.co.kr/learn/courses/30/lessons/155651
# 우선순위 큐(파이썬에서는 heapq로 주로 구현)로 풀 수 있음

import heapq

# 시간 계산
def get_minutes(s):
    return int(s[:2])*60 + int(s[3:])

def solution(book_time):
    # 예약시간 기록부 정렬부터
    bookings = sorted((get_minutes(start), get_minutes(end) + 10) for start, end in book_time)
    
    rooms = [] # 우선순위큐

    for start, end in bookings:
        if rooms and rooms[0] <= start:    # 예: 예약1이 14:20에 끝나고 예약2가 14:40에 시작
            heapq.heappop(rooms)
        heapq.heappush(rooms, end)         # 예: 첫 예약이거나, 시간이 겹쳐 방 하나를 같이 쓸 수 없는 경우
    
    return len(rooms)
