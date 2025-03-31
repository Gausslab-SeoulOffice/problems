/*
172. Factorial Trailing Zeroes

Given an integer n, return the number of trailing zeroes in n!.

Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.



Example 1:

Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.

Example 2:
Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.

Example 3:
Input: n = 0
Output: 0
 */

class Solution {
    public int trailingZeroes(int n) {
        int result = 0;
        while (n > 0) {
            n/=5;
            result +=n;
        }
        return result;
    }
}

/***
 * 이 문제는 팩토리얼을 했을때 그 결과 값에서 0이 얼마나 나오는지 확인하는 문제이다.
 * 여기서 특별히 고민하면 쉽게 결과가 나온다.
 * 5가 얼마나 나오는지 확인하는 것이다.
 * 2*5는 10인데, 10이면 0이 1개 되는거고, 2는 무조건 5가 나오면 그 안에 있기때문에, 5의 개수를 세면 된다.
 *
 * n을 5로 나눠서 그 몫을 result로 반환하면 답이 나온다.
 */