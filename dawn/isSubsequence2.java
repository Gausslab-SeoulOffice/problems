/*
392. Is Subsequence

Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).


Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false
 */

class Solution {
    public boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
        }
        return sIndex == s.length();
    }
}

/***
 * 이 문제는 s, t가 주어져 있을때, s에 있는 단어들이 순서대로 t에 들어가 있는지 확인하는 문제이다.
 *
 * 일단 각각 확인하기 위해 index를 선언해둔다.
 * 그리고 while로 반복문을 돌린다.
 * s의 단어와 t의 단어가 같으면 s의 다음 단어를 확인해야하기 때문에 sIndex++를 하고, 다르면 t의 다음 단어를 확인해야하기 때문에 tIndex++를 하면 된다.
 * 최종적으로 s단어가 다 들어가 있으면 반복문을 끝났을때, s의 길이와 같아야하기 때문에 sIndex가 s.length()와 같은지 확인하면 된다.
 */