/*
69. Sqrt(x)

Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.


Example 1:
Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.

Example 2:
Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 */

class Solution {
    public int mySqrt(int x) {
        int result = 0;
        for (long i = 1; i <= x; i++) {
            long val = i * i;
            if (val <= (long) x) {
                result = (int) i;
            } else {
                break;
            }
        }
        return result;
    }
}

/***
 * 이 문제는 루트값을 구하는 것이다.
 *
 * 일단 리턴할 결과값인 result를 0으로 선언해놓는다.
 * 그리고 소수점 계산이랑 범위 때문에 long을 가지고 온다.
 * 그리고 val 인 i*i로 제곱한 값을 의미한다.
 * 제곱값이 x보다 작거나 같으면 일단 result로 옮긴다.
 * 그리고 커지면 멈추는데, 그럼 크기전에 가장 큰 값으로 result가 되어 있을 것이다.
 * 그걸 return하면 완성이다.
 */