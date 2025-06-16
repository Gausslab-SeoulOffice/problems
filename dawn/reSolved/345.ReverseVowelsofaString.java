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
        char[] stringToChar = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        String vowels = "aeiouAEIOU";
        while (start < end) {
            while (start < end && vowels.indexOf(stringToChar[start]) == -1) {
                start++;
            }
            while (start < end && vowels.indexOf(stringToChar[end]) == -1) {
                end--;
            }
            char temp = stringToChar[start];
            stringToChar[start] = stringToChar[end];
            stringToChar[end] = temp;
            start++;
            end--;
        }
        String result = new String(stringToChar);
        return result;
    }
}

/***
 * 이 문제는 vowel를 찾아서 위치를 변경해달라는 것이다.
 *
 * 위치를 맨 앞과 맨 뒤를 확인해서 변경하라는 것이기에 start와 end를 동시에 확인해서 변경해야한다.
 * 변경하는 단어인지 확인하려면 vowels를 설정해두어야한다.
 * 일단 변경해야할 단어의 위치를 확인해야하기에 indexOf를 사용해서 있는지 확인하고, 없으면 -1이 반환되기 때문에 -1이면 start는 ++를 하고 end는 --로 위치를 옮긴다.
 * 둘 다 찾으면 이 위치에 있는 단어를 서로 바꿔주면 된다.
 * while문으로 처음부터 끝까지 돌리면 char[]를 string으로 바꾸고 반환하면 된다.
 */