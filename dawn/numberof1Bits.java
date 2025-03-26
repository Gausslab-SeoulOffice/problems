/*
191. Number of 1 Bits

Given a positive integer n, write a function that returns the number of set bits in its binary representation (also known as the Hamming weight).



Example 1:
Input: n = 11
Output: 3
Explanation:
The input binary string 1011 has a total of three set bits.

Example 2:
Input: n = 128
Output: 1
Explanation:
The input binary string 10000000 has a total of one set bit.

Example 3:
Input: n = 2147483645
Output: 30
Explanation:
The input binary string 1111111111111111111111111111101 has a total of thirty set bits.
 */

class Solution {
    public int hammingWeight(int n) {
        int count =0;
        while(n!=0){
            n = n&(n-1);
            count++;
        }
        return count;
    }
}

/***
 * 이 문제는 이진법으로 바꾸면 1이 몇개가 있냐고 물어보는 문제이다.
 *
 * n & (n - 1) 은 가장 오른쪽에 있는 1을 없애주는 비트 연산이다.
 * 그래서 몇 번 해야 n이 0이 되는지를 세면 = 1의 개수가 나온다.
 */