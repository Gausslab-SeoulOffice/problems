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
        while(sIndex< s.length() && tIndex < t.length()){
            if(s.charAt(sIndex) == t.charAt(tIndex)){
                sIndex++;
            }
            tIndex++;
        }
        return sIndex == s.length();
    }
}

/***
 * 이 문제는 s에 있는 원소들이 t에 들어가있는지, 그리고 들어간 순서대로 들어가 있는지 확인하는 문제이다.
 * ace 가 abcde안에 들어 있어서 true이지만, aec는 false가 된다.
 *
 * 일단 각각 인덱스로 확인할 예정이다.
 * s와 t안에서 돌아야한다. 각 인덱스를 확인하고, 인자가 맞는지 확인한다. 맞으면 s의 다음 인자를 확인하기 위해서 sIndex++를 해준다. 다르면 tIndex++를 해준다.
 * 여기서 중요한건 sIndex가 s.length()와 같은지 확인해야한다. 끝까지 돌았고, 순서대로라는 의미이니까 말이다.
 */