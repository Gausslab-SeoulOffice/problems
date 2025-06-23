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
        Stack<Integer> stack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                n = n * 10 + (ch - '0');
            } else if (ch == '[') {
                stack.push(n);
                n = 0;
                stringStack.push(sb);
                sb = new StringBuilder();
            } else if (ch == ']') {
                int k = stack.pop();
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
 * 이 문제는 문자열을 완성하라는 문제이다.
 *
 * stack은 숫자 저장용으로 몇 번 반복해야 하는지를 담을 것이다.
 * stringStack은 이전 문자열들을 저장할 것이다.
 * sb는 현재 문자열을 담을 것이다.
 * 숫자를 만나면 일단 숫자를 확인해서 n에 담아둔다.
 * [ 이걸 만나면 이 전에 있던 문자열을 담아둬야한다.
 * stack에 숫자를 담고, sb에 담겨 있던걸 stringStack에 담아두고, 다시 sb는 리셋을 한다.
 * ] 이걸 만나면 이제 담아 뒀던걸 가지고 문자열을 만들어줘야한다.
 * 그 전에 담아뒀던 숫자만큼 반복해서 현재 문자열을 반복하고, 밖에 있는 거랑 합쳐야하기 때문에 sb에 붙여준다.
 * 그냥 문자를 만나면 바로 붙여주면 된다.
 * 반복문이 끝나면 sb를 string으로 변환해서 반환하면 된다.
 */