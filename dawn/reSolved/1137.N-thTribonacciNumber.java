/*
1137. N-th Tribonacci Number

The Tribonacci sequence Tn is defined as follows:

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.


Example 1:
Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4

Example 2:
Input: n = 25
Output: 1389537
 */

class Solution {
    public int tribonacci(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return compute(map, n);
    }

    private int compute(Map<Integer, Integer> map, int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int result = 0;
        if (n == 0) {
            result = 0;
        } else if (n == 1 || n == 2) {
            result = 1;
        } else {
            result = compute(map, n - 1) + compute(map, n - 2) + compute(map, n - 3);
        }
        map.put(n, result);
        return result;
    }
}

/***
 * 이 문제는 tribonacci 문제이다.
 *
 * 주의할 점은 map으로 꼭 기억해놓아야한다는 것이다.
 * 그렇기 때문에 일단 map을 만들어둔다.
 * 그리고 compute로 계산을 해서 map에 넣어놓고 값을 가지고 오는 과정을 거친다.
 * 일단 찾으려고 하는 수가 map에 있으면 그대로 가지고 온다.
 * 그게 아니라면 계산을 해서 map에 넣어두면 된다.
 * 일단 0이면 0을 넣고, 1이나 2이면 1을 넣어둔다.
 * 그게 아니라면 이제 3개의 수를 조합해서 넣어두면된다.
 * 다시 compute를 불러서 가지고 있는지 확인하면 된다.
 * 이후 계산된 값은 map에 put으로 넣어두면 된다.
 */