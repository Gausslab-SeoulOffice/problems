/*
2390. Removing Stars From a String

You are given a string s, which contains stars *.

In one operation, you can:

Choose a star in s.
Remove the closest non-star character to its left, as well as remove the star itself.
Return the string after all stars have been removed.

Note:

The input will be generated such that the operation is always possible.
It can be shown that the resulting string will always be unique.


Example 1:
Input: s = "leet**cod*e"
Output: "lecoe"
Explanation: Performing the removals from left to right:
- The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
- The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
- The closest character to the 3rd star is 'd' in "lecod*e". s becomes "lecoe".
There are no more stars, so we return "lecoe".

Example 2:
Input: s = "erase*****"
Output: ""
Explanation: The entire string is removed, so we return an empty string.
 */

class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch != '*') {
                stack.push(ch);
            } else {
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}

/***
 * 이 문제는 *이 나오면 그 앞에 문자를 삭제해서 나올 수 있는 단어를 반환하는 문제이다.
 *
 * 일단 문자를 쌓을 수 있도록 stack을 선언해준다.
 * 그리고 단어를 만들 수 있도록 StringBuilder도 선언해준다.
 * 문자를 쌓을 때는 *이 나오면 그 앞에 단어를 삭제하도록 pop()을 하고, 그게 아니라면 stack에 쌓을 수 있도록 push(ch)를 한다.
 * 다 넣으면 이제 stack이 빌때까지 stringBuilder에 넣어서 단어를 만들어준다.
 * 이 단어는 거꾸로 되어 있기때문에, reverse()를 통해 뒤집어준다.
 * 이후 stringBuilder를 toString()을 사용해서 string형으로 바꾸고 반환해준다.
 */