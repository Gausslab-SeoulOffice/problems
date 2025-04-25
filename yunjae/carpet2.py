# 프로그래머스 - 카펫
# https://velog.io/@front/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%B9%B4%ED%8E%AB
# (원본 링크가 사라져 블로그 링크로 대체)
# 완전탐색 풀이 (테스트 케이스 수가 많지 않아서 가능함)

def solution(brown, yellow):
    total_tiles = brown + yellow

    for height in range(3, total_tiles):            # 안에 노란 타일이 최소 1개라도 있으면, 전체 타일 높이의 최소값은 3
      if total_tiles % height == 0:
        width = total_tiles // height
        if (width - 2) * (height - 2) == yellow:
          return sorted([width, height], reverse=True)
