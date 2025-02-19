import sys
input = sys.stdin.readline

from itertools import permutations

n, m = map(int, input().split())
numbers = sorted(list(map(int, input().split()))) 

for cs in permutations(numbers, m):
  print(*cs)
