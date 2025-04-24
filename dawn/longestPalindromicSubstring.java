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
 * 이 문제는 palindrom인 문자열중 가장 긴 문자열을 반환하는 문제이다.
 *
 * 일단 i는 팰린드롬의 중심이 될 수 있는 인덱스이다.
 * 짝수와 홀수 모두 계산을해서 새로운 최대 길이 발견 시, start와 end 업데이트를 하면 된다.
 * compute함수는 좌우 대칭으로 팰린드롬이 유지되는 한 계속 양쪽으로 확장
 * 다르면 멈추고, 그 전까지의 길이를 반환
 * 예:
 * "racecar", left=3, right=3 → 팰린드롬 길이 7
 * "abba", left=1, right=2 → 팰린드롬 길이 4
 */