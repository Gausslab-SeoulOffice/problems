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
 * 이 문제는 피보나피 수열과 비슷하다.
 * 이름처럼 이전 3개의 합을 구하면 되는것이다.
 *
 * class Solution {
 *     public int tribonacci(int n) {
 *         if (n == 0) {
 *             return 0;
 *         } else if (n == 1 || n == 2) {
 *             return 1;
 *         } else {
 *             return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
 *         }
 *     }
 * }
 *  사실 처음에 별 생각도 안하고 썻다가 TLE 났다.
 *
 * 이럴때 그냥 저장해놓고 쓰면 TLE는 해결하게 된다.
 * map에 저장해두고 꺼내쓰는 방식이다.
 * compute함수에서 해결할건데, 일단 map에 있으면 그 값을 꺼내와서 반환하면 된다.
 * 그게 아니라면 저장된 값들을 사용해서 새로운 값을 만들고 그 값을 map에 저장해서 사용하는 방식이다.
 * 일단 0 이면 0을 반환하고, 1이나 2 이면 1을 반환하고, 그게 아니라면 이전 3개의 값을 더해서 만들어야한다.
 * 이전 3개의 값은 map에 있을테니까 다시 함수를 불러주면 된다.
 * 그리고 만들어진 값을 map에 넣어주고, 최종적으로 나오는 값은 result에 더해놨으니까 compute의 리턴값은 result가 되는거고,tribonacci의 반환값은 compute가 된다.
 */