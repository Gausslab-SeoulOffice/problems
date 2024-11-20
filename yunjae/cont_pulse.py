# Goal: Find the maximum possible sum of a subsequence when multiplied by continuous pulse
# For-loop (intuitive and pythonic)

def solution(sequence):
    sumlist = [0]
    
    for i in range(len(sequence)):
        sumlist.append(sumlist[-1] + (-1)**i*sequence[i])
        
    return abs(max(sumlist) - min(sumlist))