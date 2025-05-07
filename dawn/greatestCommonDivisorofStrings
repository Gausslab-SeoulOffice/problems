/*
1071. Greatest Common Divisor of Strings

For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.


Example 1:
Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"

Example 2:
Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"

Example 3:
Input: str1 = "LEET", str2 = "CODE"
Output: ""
*/

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int lenGCD = gcd(str1.length(), str2.length());
        return str1.substring(0, lenGCD);
    }

    private int gcd(int str1Len, int str2Len) {
        while (str2Len != 0) {
            int temp = str1Len % str2Len;
            str1Len = str2Len;
            str2Len = temp;
        }
        return str1Len;
    }
}


/***
이 문제는 최대 공약수를 찾아서 그 문자열을 반환하는 문제이다.

일단 최대 공약수를 구하는 함수를 만들어준다.
두 단어의 길이를 가지고 나누기를 해서 나머지가 0이 되면 된다. 
그 수를 가지고 str1에서 0~그 숫자만큼의 문자열을 가지고 온다.
***/
