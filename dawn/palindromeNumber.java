/*
9. Palindrome Number

Given an integer x, return true if x is a palindrome, and false otherwise.


Example 1:
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */

class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int n = s.length();

        for(int i =0; i<n/2; i++){
            if(s.charAt(i)!=s.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
}

/***
 * 이 문제는 좌우를 뒤집었을때 똑같은지 확인하는 것이다.
 *
 * 내용상 string이 아니고 int가 주어지기 때문에 %, /로도 풀이가 가능할거 같았지만, 편한 string형태로 가보자한다.
 * 일단 int를 string으로 바꿔주고, 이후에 charAt으로 맨 앞과 맨 뒤를 확인하는 것이다.
 * 다르면 false, 끝까지 가면 true이다.
 */