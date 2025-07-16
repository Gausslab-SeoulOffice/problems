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
 * 이 문제는 괄호를 만들 수 있는 모든 경우의 수를 찾는 문제이다.
 *
 * 일단 조건은 s의 길이는 n*2보다 클 수 없고, (는 n보다 클 수 없고 )는 (보다 많을 수 없다.
 * 그렇기 때문에 재귀로 문제를 풀면 된다.
 * 일단 맨 처음은 아무것도 없기 때문에 open과 close는 0으로 넘기고 문자열은 ""으로 넘긴다.
 * compute에서 계산을 하는데 s.length()가 n*2와 같다면 찾은 것이기 때문에 result에 추가한다.
 * 그리고 open<n이라면 (를 추가하기 위해서 compute에 open+1로 넘기고 s에다가는 (를 추가해서 넘긴다.
 * close<open이라면 )를 추가하기 위해서 compute에 close+1로 넘기로 s에다가는 )를 추가해서 넘긴다.
 * 이후 result를 반환하면 된다.
 */