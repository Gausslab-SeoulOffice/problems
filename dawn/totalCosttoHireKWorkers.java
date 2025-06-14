/*
2462. Total Cost to Hire K Workers

You are given a 0-indexed integer array costs where costs[i] is the cost of hiring the ith worker.

You are also given two integers k and candidates. We want to hire exactly k workers according to the following rules:

You will run k sessions and hire exactly one worker in each session.
In each hiring session, choose the worker with the lowest cost from either the first candidates workers or the last candidates workers. Break the tie by the smallest index.
For example, if costs = [3,2,7,7,1,2] and candidates = 2, then in the first hiring session, we will choose the 4th worker because they have the lowest cost [3,2,7,7,1,2].
In the second hiring session, we will choose 1st worker because they have the same lowest cost as 4th worker but they have the smallest index [3,2,7,7,2]. Please note that the indexing may be changed in the process.
If there are fewer than candidates workers remaining, choose the worker with the lowest cost among them. Break the tie by the smallest index.
A worker can only be chosen once.
Return the total cost to hire exactly k workers.



Example 1:
Input: costs = [17,12,10,2,7,2,11,20,8], k = 3, candidates = 4
Output: 11
Explanation: We hire 3 workers in total. The total cost is initially 0.
- In the first hiring round we choose the worker from [17,12,10,2,7,2,11,20,8]. The lowest cost is 2, and we break the tie by the smallest index, which is 3. The total cost = 0 + 2 = 2.
- In the second hiring round we choose the worker from [17,12,10,7,2,11,20,8]. The lowest cost is 2 (index 4). The total cost = 2 + 2 = 4.
- In the third hiring round we choose the worker from [17,12,10,7,11,20,8]. The lowest cost is 7 (index 3). The total cost = 4 + 7 = 11. Notice that the worker with index 3 was common in the first and last four workers.
The total hiring cost is 11.

Example 2:
Input: costs = [1,2,4,1], k = 3, candidates = 3
Output: 4
Explanation: We hire 3 workers in total. The total cost is initially 0.
- In the first hiring round we choose the worker from [1,2,4,1]. The lowest cost is 1, and we break the tie by the smallest index, which is 0. The total cost = 0 + 1 = 1. Notice that workers with index 1 and 2 are common in the first and last 3 workers.
- In the second hiring round we choose the worker from [2,4,1]. The lowest cost is 1 (index 2). The total cost = 1 + 1 = 2.
- In the third hiring round there are less than three candidates. We choose the worker from the remaining workers [2,4]. The lowest cost is 2 (index 0). The total cost = 2 + 2 = 4.
The total hiring cost is 4.
 */

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int i =0;
        int j = costs.length-1;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        long result =0;
        while(k-->0){
            while(pq1.size()<candidates && i<=j){
                pq1.offer(costs[i++]);
            }
            while(pq2.size()< candidates && i<=j){
                pq2.offer(costs[j--]);
            }
            int answer1 = pq1.size()>0 ? pq1.peek() : Integer.MAX_VALUE;
            int answer2 = pq2.size()>0 ? pq2.peek() : Integer.MAX_VALUE;

            if(answer1<=answer2){
                result += answer1;
                pq1.poll();
            }else{
                result += answer2;
                pq2.poll();
            }
        }
        return result;
    }
}

/***
 * 이 문제는 costs에서 앞 뒤로 candidates만큼 뽑아서 제일 작은 cost를 찾아서 합을 구하는데 k번한 후에 cost를 반환하는 문제이다.
 *
 * 인덱스를 이용해야하기때문에 i,j를 이용한다. i는 맨 앞에서부터이고, j는 맨 뒤에서부터이다.
 * ProiortyQueue를 이용해서 가장 작은걸 이용할 예정이다.
 * 각각 queue에 숫자를 넣어줄텐데, 한 개는 costs[i++]이고, 한개는 costs[j--]이다.
 * candidates개만큼 넣는다.
 * 그리고 한개씩 꺼낼 예정이다.
 * 제일 작은게 제일 앞에 있을테니 peek()으로 일단 한개씩 꺼내고, answer1이 answer2보다 작거나 같으면 answer1을 이용한다.
 * 이게 아니라면 answer2를 이용한다.
 * result에 더해서 k번만큼 반복하면 된다.
 */