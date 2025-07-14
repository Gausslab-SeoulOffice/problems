/*
739. Daily Temperatures

Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.


Example 1:
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

Example 2:
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]

Example 3:
Input: temperatures = [30,60,90]
Output: [1,1,0]
 */

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}

/***
 * 이 문제는 며칠을 기다리면 현재 날보다 뜨거운 날이 오는지 구하는 문제이다.
 *
 * 일단 stack에 인덱스를 넣는다고 생각하면 된다.
 * stack에 있는 맨 위의 값보다 지금 가지고 있는거가 더크면 인덱스를 계산한다.
 * 그리고 result에 넣으면 된다.
 * 마지막으로 result를 반환하면 된다.
 */