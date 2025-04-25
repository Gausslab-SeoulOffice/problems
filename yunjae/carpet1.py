# 프로그래머스 - 카펫
# https://velog.io/@front/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%B9%B4%ED%8E%AB 
# (문제 링크 없어져 블로그 링크로 대체)
# 완전탐색 문제이지만 이분탐색으로도 풀 수 있음

def solution(brown, yellow):
  total_tiles = brown + yellow
  perimeter = (brown + 4) // 2        # perimeter== x + y에 해당. brown = 2x + 2y - 4 이기 때문 (모퉁이 4개를 빼야 하기 때문)

  # 이분탐색 초기조건 설정
  step = perimeter // 2        # 이분탐색의 upper bound; 둘레의 절반부터 시작 
                               # step을 점점 줄여나가며 width, height에 더하기/빼기하여 원하는 width, height 찾아나감
  width = step
  height = perimeter - width
  step //= 2

  # 이분탐색
  while width * height != total_tiles:
    if step != 1:
      step //= 2

    if width * height > total_tiles:
      width -= step
      height += step
    else:
      width += step
      height -= step

  return sorted([width, height], reverse=True)      # width가 더 크기 때문에 한번 sort
