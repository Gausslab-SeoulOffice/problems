/*
201. Bitwise AND of Numbers Range

Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.


Example 1:
Input: left = 5, right = 7
Output: 4

Example 2:
Input: left = 0, right = 0
Output: 0

Example 3:
Input: left = 1, right = 2147483647
Output: 0
 */

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int cnt = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            cnt++;
        }
        return (left << cnt);
    }
}

/***
 * 이 문제는 답을 봤다.
 * 일단 left와 right 사이의 숫자를 and연산 하나는 것이였다.
 *
 * 왼쪽에서부터 공통된 비트만 결과에 포함된다!
 * 왜냐면:
 * AND 연산에서는 한 자리라도 0이면 전체가 0이기 때문에,
 * left와 right 사이에 비트가 바뀌는 구간이 있다면, 그 이후 비트는 모두 0
 * int cnt = 0;
 * 비트가 얼마나 오른쪽으로 이동됐는지 카운트할 변수
 * left와 right를 오른쪽으로 쉬프트 하면서
 * 언제 두 수가 같아지는지를 찾음
 * 이때까지 바뀐 비트들은 전부 0이 될 운명이기 때문에 없애도 된다.
 */