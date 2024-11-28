from itertools import permutations

# 던전 구성을 이리저리 바꾸며 가능한 순열(permutation)을 모두 탐색
def solution(k, dungeons):
	answer = -1
	for each_case in permutations(dungeons, len(dungeons)):
		fatigue = k # 피로도
		cnt = 0
		for target in each_case:
			if fatigue >= target[0]:
				fatigue -= target[1]
				cnt += 1
		answer = max(answer, cnt)
	return answer
