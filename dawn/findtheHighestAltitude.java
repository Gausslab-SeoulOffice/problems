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
        int[] altitudeList = new int[gain.length + 1];
        altitudeList[0] = 0;
        int max = altitudeList[0];
        for (int i = 1; i <= gain.length; i++) {
            altitudeList[i] = altitudeList[i - 1] + gain[i - 1];
            max = Math.max(max, altitudeList[i]);
        }
        return max;
    }
}

/***
 * 이 문제는 계속 앞에걸 더해서 리스트를 만들어내고 그 중 가장 작은 값을 리턴하는 문제이다.
 *
 * 일단 값을 저장할 list를 만들어서 선언해준다.
 * 맨 처음은 0으로 시작해야하기 때문에 gain.length+1크기만큼 만들어준다.
 * 처음값은 0으로 설정하고, 제일 큰 수도 찾아야하기 때문에 max도 선언해주는데, 일단 0값으로 해둔다.
 * 그리고 반복문으로 앞에 만들어진수+현재값을 더해준다.
 * 그리고 max값을 업데이트 해준다.
 * 반복문을 다 돌리고 나면 업데이트 된 max값을 반환하면 된다.
 */