# LeetCode 771: Jewel and Stones
# https://leetcode.com/problems/jewels-and-stones/

# You're given strings jewels representing the types of stones that are jewels,
# and stones representing the stones you have.
# Each character in stones is a type of stone you have.
# You want to know how many of the stones you have are also jewels.

# Pythonic한 풀이: 아래 코드는 Boolean list의 총합을 반환합니다.
class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        return sum(s in jewels for s in stones)
