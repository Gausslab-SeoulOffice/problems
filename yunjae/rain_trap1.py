# LeetCode 42. Trapping Rain Water
# Two pointer를 이용한 풀이.
# while 루프를 돌리면서, elevation의 최고점을 찾아 양쪽의 포인터를 수렴시켜 나간다.
# 직전 값보다 높이가 낮은 곳을 만나면 그곳에는 물이 찰 것이다.
# 이 차이만큼 volume에 더해 나간다.

class Solution:
	def trap(self, height: List[int]) -> int:
		if not height:
		    return 0
		volume = 0
		left, right = 0, len(height) - 1 # two-pointer
		# 양쪽 최댓값을 처음/끝 값으로 각각 초기화
		left_max, right_max = height[left], height[right]
	
		while left < right: # 둘 다 최댓값의 인덱스를 향해 수렴할 때까지
			left_max, right_max = max(height[left], left_max), max(height[right], right_max)
			if left_max <= right_max: # 오른쪽이 더 크거나 같다면, 왼쪽 포인터를 더 이동시켜야 한다
				volume += left_max - height[left]
				left += 1
			else:
				volume += right_max - height[right]
				right -= 1
		return volume
