/*
5. Longest Palindromic Substring

Given a string s, return the longest palindromic substring in s.


Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"
 */

class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int odd = compute(s, i, i);
            int even = compute(s, i, i + 1);
            int max = Math.max(odd, even);

            if (max > end - start) {
                start = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int compute(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}

/***
 * 이 문제는 palindromic이 가장 긴 문장을 찾는 문제이다.
 *
 * 일단 시작점과 끝점을 0으로 두고 시작한다.
 * 홀수 짝수를 나눠서 찾을 예정이다.
 * compute함수는 내가 있는 위치에서 palindrome이 되면 양 옆으로 증가시켜나가는 것이다.
 * 더이상 palindrome이 아니면 그 길이를 반환시키면 된다.
 * 이후 odd랑 even이랑 더 큰걸 max로 둔다.
 * max가 갱신되면 start랑 end를 업데이트 시켜주면 된다.
 * for문을 끝까지 돌리면 가장 긴 길이가 start와 end에 들어가 있기 때문에 substring으로 반환하면 된다.
 */