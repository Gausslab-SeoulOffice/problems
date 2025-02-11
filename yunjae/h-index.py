def h_index(citations):
  citations.sort(reverse=True) # 인용수 리스트를 내림차순으로 정렬

  # 내림차순 정렬된 리스트에서, 'n번째 값이 최초로 n보다 작아질 때'부터 우리가 원하는 조건에 어긋나게 된다,
  # 따라서 우리가 원하는 조건을 충족해 준 마지막 값(n번째에서 바로 앞 순번까지의 원소 개수), 즉 n-1이 h-Index가 된다.
  # (배열 원소의 인덱스 i는 0부터 시작하므로, 현실의 순번 n = i+1임에 유의해야 함)
  # 예) [7, 6, 6, 6, 5, 1]일 경우, 6번째 값이 최초로 6보다 작아진다. 따라서 h-index는 5

  for i in range(len(citations)):
    if citations[i] < i+1: 
      return i

  return len(citations) # edge case: 인용 횟수가 [4, 4, 4]와 같이 모두 같을 경우(이 예시에서 h-index는 3) 
