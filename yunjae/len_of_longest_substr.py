# LeetCode - Length of Longest Substring Without Repeating Characters (중복 문자 없는 가장 긴 부분문자열)
# https://leetcode.com/problems/longest-substring-without-repeating-characters/
# 딕셔너리와 투포인터(start, index)를 이용한다.

def lengthOfLongestSubstring(self, s: str) -> int:
	used = {} # 지금껏 살펴본 문자들의 인덱스가 저장된다
	max_length = start = 0

	for index, char in enumerate(s):
		# 이미 등장했던 문자라면 'start'의 위치를 한 칸 앞으로 당겨주어야 한다
		if char in used and start <= used[char]: # sliding window 바깥의 문자는 이전에 등장했더라도 무시해야 한다
			start = used[char] + 1
		else: # 처음 나타난 문자라면
			max_length = max(max_length, index - start + 1) # 최대 sliding window 길이 갱신

		# 현재 문자의 위치 삽입
		used[char] = index

	return max_length
