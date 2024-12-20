class Solution:
	longest: int = 0

	def diameterOfBinaryTree(self, root: TreeNode) -> int:
		def dfs(node: TreeNode) -> int:
			if not node:
				return -1
			# 왼쪽, 오른쪽의 각 leaf node까지 탐색
			left = dfs(node.left)
			right = dfs(node.right)

			# 가장 긴 거리; max(이전까지 나타난 거리, 최신 거리)
			self.longest = max(self.longest, left + right + 2)
			# 상태값
			return max(left, right) + 1

		dfs(root)
		return self.longest
