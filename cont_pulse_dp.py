# Dynamic Programming
# Slow for some test cases (I just wanted to practice DP)

def solution(sequence):
    n = len(sequence)
    
    pulsed1 = [sequence[i]*(-1)**i for i in range(n)]
    pulsed2 = [sequence[i]*(-1)**(i+1) for i in range(n)]

    dp1 = [0]*n 
    dp2 = [0]*n

    dp1[0] = pulsed1[0]
    dp2[0] = pulsed2[0]

    for i in range(1, n):
        dp1[i] = max(dp1[i-1]+pulsed1[i], pulsed1[i])
        dp2[i] = max(dp2[i-1]+pulsed2[i], pulsed2[i])
        
    return max(max(dp1), max(dp2))