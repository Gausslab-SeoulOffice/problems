/*
224. Basic Calculator

Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().



Example 1:
Input: s = "1 + 1"
Output: 2

Example 2:
Input: s = " 2-1 + 2 "
Output: 3

Example 3:
Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23

 */

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int sign = 1;
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                num *= sign;
                answer += num;
                num = 0;
                sign = 1;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(answer);
                stack.push(sign);
                answer = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                int prevSign = stack.pop();
                answer = prevSign * answer;
                int prevAnswer = stack.pop();
                answer = prevAnswer + answer;
            }
        }
        return answer;
    }
}

/***
 * 이 문제는 괄호가 있는 덧셈, 뺄셈을 진행하는 것이다.
 *
 * +, -를 괄호앞에 사용할 수 있는데, 그 경우에 -를 곱한것과 같다. 이점을 유의하고 넘어가자
 * 일단 stack한 개를 선언한다. 그리고 지금 숫자는 num이라고 선언하고 부호는 sign, 정답은 answer로 선언한다.
 * 일단 입력된 모든 걸 돌거고, 여기서 숫자를 확인해야하는데 string으로 들어오기 때문에 이거를 int로 바꾸기 위해 s.charAt(i)-'0'을 한다.
 * 그리고 숫자는 여러자리 숫자일 수 있기에 while을 사용해서 숫자를 모조리 찾는다.
 * 그리고 nums랑 앞에 부호가 뭔지에 따라 곱해준다. 그러면 정확한 숫자가 나오기때문에 이 숫자는 answer과 더해서 갱신해놓는다. 그리고 num과 sign을 리셋시킨다.
 * 이제 +나 -가 들어오는 경우는 sign을 변경시킨다.
 * 괄호가 들어오는 경우는 stack을 이용하게 된다.
 * 열리는 괄호이면 stack에다가 정답과 sign을 넣고, 리셋시킨다. 닫히는 괄호이면 그 전에 있던걸 꺼내와서 계싼하면 되는것이다.
 * 그 전에 넣은 sign을 가지고 와서 answer과 곱해주고, 그 전에 계산해놨던 answer과 막구한 answer를 더해주면 된다.
 */