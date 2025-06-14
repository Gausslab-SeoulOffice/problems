# LeetCode - 섬의 개수
# https://leetcode.com/problems/number-of-islands/
# 재귀 DFS 연습


class Solution:
	def numIslands(self, grid: List[List[str]]) -> int:
		def dfs(i, j):
			# 더 이상 땅이 아니면 종료
			if i < 0 or i >= len(grid) or j < 0 or j >= len(grid[0]) or grid[i][j] != '1':
				return
			grid[i][j] = 0

			dfs(i+1, j)
			dfs(i-1, j)
			dfs(i, j+1)
			dfs(i, j-1)

		count = 0
		for i in range(len(grid)):
			for j in range(len(grid[0])):
				if grid[i][j] == '1':
					dfs(i, j)
					# 모든 육지 탐색 후 숫자 파악
					count += 1
		return count
