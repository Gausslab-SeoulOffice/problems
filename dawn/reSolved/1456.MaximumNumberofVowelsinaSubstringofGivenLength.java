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
 * 이 문제는 순서대로 알파벳을 k개 만큼 뺏을경우 vowels가 포함되어 있는지 묻는 문제이다.
 *
 * 일단 vowels를 string으로 선언해주고, 지금 가지고 있는 vowel의 갯수를 세기 위해 answer를 선언해준다.
 * 최대 값을 구해야하기 때문에 max도 선언해준다.
 * 그리고 for문으로 처음부터 끝까지 확인할 것이다.
 * 근데 max는 k보다 클 수 없다.
 * max와 k가 같다면 max를 바로 반환한다.
 * 일단 알파벳 한개씩 확인을 하는데 indexOf를 사용한다.
 * 0보다 크거나 같으면 존재한다는 의미이다.
 * 그런경우엔 answer를 증가시켜주면 된다.
 * 여기서 중요한건 subString이 k를 넘어가면 다시 확인해줘야한다는 것이다.
 * i>=k 이라면 맨 앞 단어를 포기하고 다음단어로 넘어가야한다는 것이다.
 * 그렇다면 포기하는 단어가 vowel이라면 answer에서도 빼줘야한다.
 * 그리고 매번 단어가 변경될때마다 max를 업데이트 시켜주면 된다.
 * for문을 다 돌리면 max를 반환하면 된다.
 */