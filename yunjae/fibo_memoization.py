n = int(input())

memo = [0, 1]

def fib(n):
  if n >= 2 and n >= len(memo):
    memo.append(fib(n-1) + fib(n-2))
  return memo[n]

print(fib(n))
