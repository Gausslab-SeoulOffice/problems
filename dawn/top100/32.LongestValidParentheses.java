/*
32. Longest Valid Parentheses

Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.


Example 1:
Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".

Example 2:
Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".

Example 3:
Input: s = ""
Output: 0
 */

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}

/***
 * 이 문제는 괄호의 쌍을 찾아서 반환하는 문제이다.
 *
 * stack에는 인덱스를 쌓아서 갯수를 max로 계산할 예정이다.
 * 일단 맨 처음에 괄호가 () 이렇게 시작할 수 있기 때문에 -1을 넣어준다.
 * 그리고 (가 나오게 된다면 stack에 인덱스를 넣어준다.
 * )가 나오면 쌍을 stack에 맨위를 pop으로 빼준다.
 * 만약에 stack이 비어 있다면 stack에 넣어준다.
 * 쌍이 없다는 의미이기에 그냥 넣기만 하고 있다면 쌍이 될 괄호가 있다는 의미기이게 max 계산을 한다.
 * 그 이후 max를 반환하면 된다.
 */