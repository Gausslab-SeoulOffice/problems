/*
452. Minimum Number of Arrows to Burst Balloons

There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.

Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.

Given the array points, return the minimum number of arrows that must be shot to burst all balloons.


Example 1:
Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2
Explanation: The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].

Example 2:
Input: points = [[1,2],[3,4],[5,6],[7,8]]
Output: 4
Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.

Example 3:
Input: points = [[1,2],[2,3],[3,4],[4,5]]
Output: 2
Explanation: The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
- Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
 */

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 1;
        int prevEnd = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (prevEnd < points[i][0]) {
                count++;
                prevEnd = points[i][1];
            }
        }
        return count;
    }
}

/***
 * 이 문제는 몇개의 화살로 풍선을 다 터트릴수 있는지 구하는 문제이다.
 *
 * 일단 int라는 조건이 있어서 sort를 할때 Integer.compare(a[1], b[1])로 해야한다.
 * 그리고 prevEnd를 설정해서 그 다음 배열에서 첫번째 원소가 prevEnd보다 크면 서로 독립된것이다.
 * 그럼 count를 증가시키고 prevEnd를 업데이트 시켜주면 된다.
 * 이후 count를 반환하면 된다.
 */