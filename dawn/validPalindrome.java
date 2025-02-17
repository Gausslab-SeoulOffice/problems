/*
125. Valid Palindrome

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.



Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 */

class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

/***
 * 일단 이 문제는 가장 간단한 문제였다.
 * 문자열이 나오면 맨 뒤부터 맨 앞까지 대칭이 되는 Palindrome 인가?를 물어보는 문제다.
 *
 * 가장 인상 깊게 쓴 부분은 replaceAll부분이다. 일단 toLowerCase()로 바꾸고, 그 이후에 공백이나 숫자, ; ,과 같은 것들은 문자들은 공백이 없이 하나로 다 붙여주는 작업이다.
 * 이후엔 왼쪽과 오른쪽 인덱스부터 비교를 하면 된다.
 * 둘이 같지 않으면 false, left < right까지 할때 둘이 끝까지 같으면 true를 반환한다.
 */