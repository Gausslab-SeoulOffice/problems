/*
58. Length of Last Word

Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal
substring
 consisting of non-space characters only.


Example 1:
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

Example 2:
Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.

Example 3:
Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.
 */

class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        int answer = words[words.length-1].length();
        return answer;
    }
}

/***
 * 이 문제는 string이 주어지고 공백(" ")으로 단어가 나워져 있으면, 마지막 단어의 길이를 return하라는 문제이다.
 *
 * split을 사용하면 쉽게 풀 수 있는 문제이다.
 * split(" ")을 사용하여 단어리스트를 words에 저장한다.
 * 이후 맨 마지막에 있는걸 가져오기 위해 words.length-1을 사용해서 맨 마지막 인덱스를 가지고 오고,
 * words[words.length-1).length()로 길이를 가져와서 리턴하면 된다.
 */