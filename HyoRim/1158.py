import sys

def Josephus(queue, K):
    result = list()
    for i in range(len(queue)):
        if (len(queue)>K):
            for i in range(K - 1):
                queue.append(queue.pop(0))
            result.append(queue.pop(0))
        elif (len(queue) <= K):
            result.append(queue.pop(K%len(queue) - 1))
    return result

N, K = map(int, sys.stdin.readline().split())
queue = list()
for i in range(1, N + 1):
    queue.append(i)
result = Josephus(queue, K)
print('<', end='')
for i in range(N):
    if (i != N -1):
        print(f'{result[i]}, ', end="")
    else:
        print(f'{result[i]}', end="")
print('>', end="")