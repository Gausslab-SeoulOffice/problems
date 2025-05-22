/*
394. Decode String

Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.


Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Example 2:
Input: s = "3[a2[c]]"
Output: "accaccacc"

Example 3:
Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
 */

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                n = n * 10 + (ch - '0');
            } else if (ch == '[') {
                numStack.push(n);
                n = 0;
                stringStack.push(sb);
                sb = new StringBuilder();
            } else if (ch == ']') {
                int k = numStack.pop();
                StringBuilder temp = sb;
                sb = stringStack.pop();
                while (k-- > 0) {
                    sb.append(temp);
                }
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}

/***
 * 이 문제는 대괄호가 섞여있고, 문자열을 앞에 나온 수만큼 반복해서 만들어서 반환하라는 문제이다.
 *
 * 일단 숫자들을 넣을 stack, 문자를 넣을 stack을 만들어주고, 최종적으로 만들 문자인 StringBuilder를 한 개 선언해준다.
 * 숫자가 두자리 숫자일 수 있기 때문에, Character.isDigit으로 판별하고, 숫자를 일단 만들어서 n에 저장한다.
 * 그리고 대괄호가 나오면 만들어둔 문자열과 숫자를 저장해야하기때문에, 일단 숫자n을 stack에 넣고, 이제까지 만들어놓은 문자열을 stringStack에 넣어준다.
 * 그리고 문자열을 다시 초기화 시켜놓는다.
 * 대괄호가 닫히면 반복 횟수 꺼내고, 현재 괄호안에 문자열을 temp로 옮기고, 이전 문자열로 복귀한다.
 * 그리고 k번만큼 문자열을 반복해서 넣어준다.
 * 만약 그냥 알파벳이면 현재 문자열에 알파벳 추가한다.
 * 그 이후에 toString()을 이용해서 반환한다.
 */