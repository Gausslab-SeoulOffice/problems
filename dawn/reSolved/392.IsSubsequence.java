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
            if (s.charAt(sIndex) == (t.charAt(tIndex))) {
                sIndex++;
            }
            tIndex++;
        }
        return sIndex == s.length();
    }
}

/***
 * 이 문제는 s에 있는 단어들이 t에 순서대로 있는지 확인하는 문제이다.
 *
 * 각각의 인덱스를 사용하면 되기 때문에 sIndex, tIndex를 선언해둔다.
 * 그리고 while문을 돌려 각자 문장의 끝까지를 확인하면 된다.
 * s에서 한개를 가지고 오고 t에서 한개를 가지고 와서 비교를 한다.
 * 같으면 s를 다음으로 넘기고 t도 다음으로 넘기면 된다.
 * 다르면 s는 그대로 두고 t만 다음으로 넘기면 된다.
 * 이후 while문을 나오게 되면 s든 t든 끝났다는 의미이다.
 * 여기서 sIndex와 s의 길이가 같다는건 s를 다 찾았다는 의미기에 같으면 true를 반환하고, 그게 아니라면 false를 반환하게 된다.
 */