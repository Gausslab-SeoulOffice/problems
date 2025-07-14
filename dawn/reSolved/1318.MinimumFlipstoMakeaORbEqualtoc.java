/*
1318. Minimum Flips to Make a OR b Equal to c

Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.


Example 1:
Input: a = 2, b = 6, c = 5
Output: 3
Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)

Example 2:
Input: a = 4, b = 2, c = 7
Output: 1

Example 3:
Input: a = 1, b = 2, c = 3
Output: 0
 */

class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;

        for (int i = 0; i < 32; i++) {
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitC = (c >> i) & 1;

            if ((bitA | bitB) == bitC) {
                continue;
            }

            if (bitC == 0) {
                flips += bitA + bitB;
            } else {
                flips += 1;
            }
        }
        return flips;
    }
}


/***
 * 이 문제는 정수 a, b, c가 주어졌을 때, (a | b) == c가 되도록 a와 b의 비트 중 일부를 flip(0 ↔ 1) 하여, 최소 몇 번 flip 해야 하는지 구하는 문제이다.
 *
 * 비트 단위로 a, b, c를 비교한다.
 * 각 비트 자리(i)에 대해: (a >> i) & 1 → a의 i번째 비트, (a | b)의 i번째 비트와 c의 i번째 비트를 비교하고 다르면 flip 필요하다.
 * 어떤 비트를 어떻게 바꿔야 (a | b)의 결과가 c의 비트와 같아질 수 있는지 판단
 *
 * c_i == 0인데 (a | b)_i != 0이라면
 * 즉 bitA == 1 또는 bitB == 1 → 0으로 만들려면 flip 필요
 * 두 비트가 모두 1일 수도 있으니 → bitA + bitB만큼 flip
 * ❗ c_i == 1인데 (a | b)_i == 0이라면
 * 즉 bitA == 0이고 bitB == 0 → 최소한 하나는 1로 flip 해야 함 → flip 1회
 */