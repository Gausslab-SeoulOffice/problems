/*
50. Pow(x, n)

Implement pow(x, n), which calculates x raised to the power n (i.e., xn).


Example 1:
Input: x = 2.00000, n = 10
Output: 1024.00000

Example 2:
Input: x = 2.10000, n = 3
Output: 9.26100

Example 3:
Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */

class Solution {
    public double myPow(double x, int n) {
        return compute(x, (long) n);
    }

    private double compute(double x, long n){
        if(n == 0){
            return 1;
        }
        if(n<0){
            return 1.0 / compute(x, -n);
        }
        if(n%2==1){
            return x * compute(x*x, (n-1)/2);
        }else{
            return compute(x*x, n/2);
        }
    }
}

/***
 * 이 문제는 n번 제곱 계산을 구하는 문제이다.
 *
 * 일단 범위 때문에 n을 long으로 바꿔야해서 함수를 다시 썻다.
 * 그리고 n이 0이면 1을 return하고, 0보다 작은 음수와 큰 양수를 나눠서 생각을 해야한다.
 * 일단 음수인경우는 2의 -2를 하게 된다면 1/2의2 가 될 수 있다.
 * 그러면 1.0 / compute(2, -n)을 하면 된다.
 * 그리고 양수인 경우를 잘 생각해야한다.
 * 재귀적으로 계속 부르면 되는데, 만약 n이 4라면 ((2의2)의2)가 되기 때문에, x를 일단 제곱한 후에, n을 n/2로 다시 부르면 된다.
 * 만약 n이 5라면 2x((2의 2)의2)가 되기 때문에 일단 x를 곱한 후에 다시 재귀로 부를때, x를 일단 제곱한 후에, n을 (n-1)/2로 다시 부르면 된다.
 */