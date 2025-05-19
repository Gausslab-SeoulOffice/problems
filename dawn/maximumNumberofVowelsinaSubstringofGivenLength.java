/*
1456. Maximum Number of Vowels in a Substring of Given Length

Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.



Example 1:
Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.

Example 2:
Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.

Example 3:
Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.
 */

class Solution {
    public int maxVowels(String s, int k) {
        String vowels = "aeiou";
        int answer = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (max == k) {
                return max;
            }
            if (vowels.indexOf(s.charAt(i)) >= 0) {
                answer++;
            }
            if (i >= k) {
                if (vowels.indexOf(s.charAt(i - k)) >= 0) {
                    answer--;
                }
            }
            max = Math.max(max, answer);
        }
        return max;
    }
}

/***
 * 이 문제는 k개의 문자열에서 모음이 얼마나 있는지 확인하는 문제이다.
 *
 * 일단 모음을 확인해야하기 때문에 vowels 변수를 선언한다.
 * 그리고 갯수를 세는 answer, 최대값을 확인하는 max 변수를 선언한다.
 * 그리고 한개씩 확인을 하게 된다.
 * k보다 max가 클 수는 없기에 k와 max가 같으면 max를 반환한다.
 * 지금 바라보고 있는 문자가 모음이라면 answer를 ++해준다.
 * 만약에 길이를 넘어서게 된다면 한개씩 앞에서부터 빠져나가야하는데, 그 맨 앞에 빠져나가는 값은 i-k번째일것이다.
 * 그 빠지는 값이 모음이라면 answer--를 해줘야한다.
 * 반복문을 돌면서 max를 업데이트 해줘야한다.
 * 반복문을 다 돌면 가장 큰 값이 max에 있기때문에 max를 반환해준다.
 */