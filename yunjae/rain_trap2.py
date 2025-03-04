# LeetCode 42. Trapping Rain Water
# 스택을 이용한 풀이
# - stack은 주로 데이터를 **기억**할 때 쓰인다.
# 여기에서는 인덱스를 계속 채워서 기억시키다가
# 새로운 기둥이 이전 기둥보다 높을 경우, 즉 변곡점(inflection point)을 만날 때마다 스택에서 하나씩 값을 꺼낸다.
# 이는 **stack에 채워진 인덱스의 값보다 높이가 높을 경우 물이 담긴다**는 추론에 기인한 발상이다.
# 새로운 기둥과 이전 기둥과의 가로 및 세로 차이만큼 물 높이를 채워나간다.

# `stack.pop()`: 현재 인덱스 바로 전의 인덱스이자, **물이 고이는 바닥면**의 인덱스. 이를 `top` 변수에 할당한다.
# 이게 파악될 때에만 **물높이**인 `height[top]`이 계산된다.
# `stack[-1]`: **비교 대상 기둥**의 인덱스
# `distance`: 현재 기둥에서 비교할 기둥까지의 **이격거리**. (현재 기둥 idx - 비교할 기둥 idx - 1)
# `waters`: 각 단계에서 쌓일 물의 높이. (min(현재 기둥 높이, 비교할 기둥 높이) - top의 높이)

class Solution:
    def trap(self, height: List[int]) -> int:
        stack = []
        volume = 0
	
        for i in range(len(height)):
            while stack and height[i] > height[stack[-1]]: # 변곡점을 감지하고
                top = stack.pop()  # 물이 고이는 바닥면의 인덱스
                if not len(stack):
                    break
		
                distance = i - stack[-1] - 1  # 가로; 현재 기둥 idx - 비교할 기둥 idx - 1
                waters = min(height[i], height[stack[-1]]) - height[top] # 세로; min(현재 기둥 높이, 비교할 기둥 높이) - 바닥면 기둥 높이

                volume += distance * waters
            stack.append(i)
        return volume
