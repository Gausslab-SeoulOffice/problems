/*
20. Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true
 */

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.size() == 0) {
                stack.push(s.charAt(i));
            } else if (stack.peek() == '(') {
                if (s.charAt(i) == ')') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            } else if (stack.peek() == '{') {
                if (s.charAt(i) == '}') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            } else if (stack.peek() == '[') {
                if (s.charAt(i) == ']') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}

/***
 * 이 문제는 짝을 맞춰서 짝이 맞으면 true 짝이 안맞으면 false를 반환하는 문제다.
 *
 * 일단 stack한 개를 선언해서 넣어줄 공간을 마련한다.
 * 그리고 한개도 없으면 일단 그건 당연히 넣어야하기 때문에 size()==0이면 push 해준다.
 * 그리고 stack에 맨 위를 확인하기 위해 peek()을 해서 (,{,[ 인지 확인하고 지금 내가 넣을거랑 짝이 맞다면 pop으로 빼준다.
 * 그게 아니라면 push로 지금 가지고 있는걸 넣어준다.
 * for문이 다 돌았다면 현 stack에 size가 0인지 확인하고 0이면 true, 아니면 false를 반환한다.
 */