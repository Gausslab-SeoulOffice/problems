/*
190. Reverse Bits

Reverse bits of a given 32 bits unsigned integer.

Note:
Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.


Example 1:
Input: n = 00000010100101000001111010011100
Output:    964176192 (00111001011110000010100101000000)
Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.

Example 2:
Input: n = 11111111111111111111111111111101
Output:   3221225471 (10111111111111111111111111111111)
Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.
 */

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reverse = 0;
        for(int i = 1; i<=32; i++){
            reverse = reverse<<1;
            reverse = reverse | (1&n);
            n=n>>1;
        }
        return reverse;
    }
}

/***
 * 이 문제는 비트를 뒤집어서 int로 반환하는 것이다.
 *
 * reverse = reverse << 1;결과 비트를 한 칸 왼쪽으로 밀어줌 (빈 자리 만들어줌)
 * n & 1 : n의 마지막 비트(오른쪽 1자리)만 추출
 * | : 결과에 그 비트를 붙임
 * n = n >> 1; 이미 쓴 마지막 비트는 버리고, 다음 비트를 보기 위해 오른쪽으로 밀어줌
 */