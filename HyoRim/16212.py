import sys

N = input()
num_list = map(int, sys.stdin.readline().split())
num_list = list(num_list)
num_list.sort()

for num in num_list:
    print(num, end=' ')