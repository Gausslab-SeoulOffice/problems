/*
1732. Find the Highest Altitude

There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes. The biker starts his trip on point 0 with altitude equal 0.

You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n). Return the highest altitude of a point.


Example 1:
Input: gain = [-5,1,5,0,-7]
Output: 1
Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.

Example 2:
Input: gain = [-4,-3,-2,-1,4,3,2]
Output: 0
Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.
 */

class Solution {
    public int largestAltitude(int[] gain) {
        int[] altitude = new int[gain.length + 1];
        altitude[0] = 0;
        int max = altitude[0];
        for (int i = 1; i <= gain.length; i++) {
            altitude[i] = altitude[i - 1] + gain[i - 1];
            max = Math.max(max, altitude[i]);
        }
        return max;
    }
}

/***
 * 이 문제는 앞에서부터 차근차근더해서 가장 높은 고도를 구하는 문제이다.
 * 시작은 0에서부터 시작한다.
 *
 * 일단 배열을 한개 선언한다.
 * 맨 처음은 0으로 시작해야하기 때문에 altitude[0]은 0으로 설정한다.
 * 가장 높은 곳을 선택해야하기때문에 max를 선언하고, 처음 값으로 설정해놓는다.
 * 그리고 그 전 값을 현재 값이랑 더해서 만들어준다.
 * 매번 max값을 업데이트 한다.
 * 가장 큰 값을 반환하기 위해 max를 반환하면 된다.
 */