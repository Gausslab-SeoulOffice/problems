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
 * 세 개의 정수 a, b, c가 주어졌을 때, a | b == c (a OR b가 c와 같게) 만들기 위해 각 비트마다 최소 몇 번의 비트를 뒤집어야 하는지 구하라는 문제이다.
 *
 * 각 비트 자리를 따로 보고, 아래 기준에 따라 count:
 * c의 해당 비트가 1일 때:
 * - a나 b 중 하나라도 1이면 OK (a | b = 1이 되니까)
 * - 둘 다 0이면 → 둘 중 하나를 1로 바꿔야 함 → +1 flip
 * c의 해당 비트가 0일 때:
 * - a나 b가 1이면 OR 결과가 1 → 틀림 → 해당 1을 모두 0으로 바꿔야 함
 * - 즉, a와 b의 해당 비트가 1인 개수만큼 → +1 또는 +2 flip
 *
 * int a = 6;  // 0110
 * for (int i = 0; i < 4; i++) {
 *     int bit = (a >> i) & 1;
 *     System.out.println("a의 " + i + "번째 비트: " + bit);
 * }
 * a의 0번째 비트: 0
 * a의 1번째 비트: 1
 * a의 2번째 비트: 1
 * a의 3번째 비트: 0
 */