/*
150. Evaluate Reverse Polish Notation

You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.


Example 1:
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

Example 2:
Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6

Example 3:
Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 */

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second - first);
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second / first);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
}

/***
 * 이 문제는 stack을 사용해서 사칙연산을 하라는 문제이다.
 *
 * 일단 stack에 숫자를 쌓을것이기 때문에 선언해준다.
 * 그리고 tokens을 한개씩 확인하는데 +이면 그 앞에 두 숫자를 더해서 다시 stack에 넣어준다.
 * -이면 뒤에 들어간 숫자 - 앞에 들어간 숫자를 해야해서. first, second를 한 개씩 빼고, second - first를 한다.
 * *이면 앞에 두 숫자를 곱해서 다시 stack에 넣어준다.
 * /이면 뒤에 들어간 숫자 / 앞에 들어간 숫자를 해야해서, first, second를 한 개씩 빼고, second / first를 한다.
 * 그것도 아니면 숫자이기 때문에 그냥 stack에 int로 바꿔서 넣어준다.
 * 다 돌리고 나면 stack에 숫자가 남을 것이고 이걸 peek()으로 return 하면 된다.
 */