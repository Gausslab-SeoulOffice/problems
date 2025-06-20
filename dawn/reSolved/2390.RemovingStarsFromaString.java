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
 * 이 문제는 *이 나오면 앞에 있는 문자를 제거하고 출력하라는 문제이다.
 *
 * 일단 stack으로 문자를 쌓을것이다.
 * *이 들어오면 앞에 있는걸 빼면 되기때문에 pop()을 사용해준다.
 * 이후 다 했으면 이 stack에 있는 것들을 stringbuilder에 넣어주는 작업을 한다.
 * stringbuilder에 다 넣으면 string으로 변경하면 되는데 stack의 위에서 뺀 것들이기에 반대로 되어 있다.
 * .reverse()를 사용해서 뒤집어서 반환한다.
 */