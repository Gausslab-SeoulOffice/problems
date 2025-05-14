/*
345. Reverse Vowels of a String

Given a string s, reverse only all the vowels in the string and return it.
The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.


Example 1:
Input: s = "IceCreAm"
Output: "AceCreIm"
Explanation:
The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:
Input: s = "leetcode"
Output: "leotcede"
 */

class Solution {
    public String reverseVowels(String s) {
        char[] word = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        String vowels = "aeiouAEIOU";

        while (start < end) {
            while (start < end && vowels.indexOf(word[start]) == -1) {
                start++;
            }

            while (start < end && vowels.indexOf(word[end]) == -1) {
                end--;
            }

            char temp = word[start];
            word[start] = word[end];
            word[end] = temp;

            start++;
            end--;
        }
        String answer = new String(word);
        return answer;
    }
}

/***
 * 이 문제는 모음을 찾아서 맨앞, 맨뒤 위치를 바꾸는 문제이다.
 *
 * 일단 맨 앞, 맨 뒤를 찾아 내기 위해서 start, end를 선언한다.
 * 그리고 vowels 모음을 string으로 선언해서 indexOf를 사용해서 찾아주기로 한다.
 * indexOf는 그 단어가 있으면 0, 없으면 -1을 반환한다.
 * 맨 앞 모음을 찾을때까지 start++을 한다.
 * 맨 뒤 모음을 찾을때까지 end--를 한다.
 * 그 두개를 찾으면 temp를 사용해서 자리를 교체한다.
 * 그리고 start++, end--를 해서 다음껄 찾아주러간다.
 * while반복문을 다 돌리고 나면 위치가 변화한걸 알 수 있다.
 * 이걸 return하면 된다.
 */