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

        int n = compute(str1.length(), str2.length());
        return str1.substring(0, n);
    }

    private int compute(int str1Len, int str2Len) {
        while (str2Len != 0) {
            int temp = str1Len % str2Len;
            str1Len = str2Len;
            str2Len = temp;
        }
        return str1Len;
    }
}

/***
 * 이 문제는 반복되는 단어중 최소의 단어를 찾으라는 문제이다.
 *
 * 일단 걸러내야하는 것이 문장이 반복되는게 없는 경우이다.
 * 이땐 str1+str2와 str2+str1이 같은지 확인해야한다.
 * 만약 다르다면 반복되는 경우가 아니라는 것이기에 ""을 반환하면 된다.
 * 같다면 반복되는게 확인되는 것이기에 반복되는 최소 단어를 찾아야한다.
 * 두개의 단어를 주어주고 최대공약수를 찾으면 된다.
 * 6,4라면 일단 6%4를 하면 된다.
 * 그럼 temp에 2가 들어가게 되고, str1은 4로 변경하고, str2는 temp로 변경해준다.
 * 그리고 4%2를 하면 0이 되기때문에 최대공약수는 2가 된다는걸 알 수 있다.
 * 그럼 다시 돌아와서 2자리까지 문자를 반환하면 되기 때문에 substring으로 잘라서 반환한다.
 */