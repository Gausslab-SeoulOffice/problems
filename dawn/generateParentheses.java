/*
22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.


Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]
 */

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        compute(n, result, 0, 0, "");
        return result;
    }

    private void compute(int n, List<String> result, int open, int close, String s) {
        if (s.length() == n * 2) {
            result.add(s);
            return;
        }

        if (open < n) {
            compute(n, result, open + 1, close, s + "(");
        }
        if (close < open) {
            compute(n, result, open, close + 1, s + ")");
        }
    }
}

/***
 * 이 문제는 괄호를 사용하여 원하는 숫자만큼 짝을 맞춘 괄호의 string을 구하는 문제이다.
 *
 * dfs랑 더 맞지 않나 생각이 든다.
 * 일단 결과를 출력할 result를 한개 만들고 compute 함수를 따로 뺀다.
 * 이 함수는 열린괄호의 수와 닫힌 괄호의 수를 추가하여 string을 만들 예정이다.
 *
 * 일단 string의 길이가 n*2와 같으면 사용해야할 모든 괄호의 수를 다 사용했다는 것이기에 result에 추가하고 return;을 시킨다.
 * 그리고 open의 갯수가 n보다 아직 작다면 compute를 다시 돌리는데 stirng에 ( 열린괄호 한개를 더 추가해주고, open개수도 1 추가한다.
 * 그리고 close의 갯수가 open보다 작다면 이건 열린ㅎ괄호가 더 많다는 이야기로 닫힌 괄호를 넣어야하는 것이기에 string에 ) 닫힌 괄호를 추가하고 close에 1을 더하면 된다.
 * 이렇게 되면 모든 경우의 수가 만들어진다.
 * 특히 닫힌 괄호는 열린괄호 다음에 들어가야하기때문에 마지막 if가 중요하게 되겠다.
 */