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
        int arrows = 1;
        int prevSecond = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (prevSecond < points[i][0]) {
                arrows++;
                prevSecond = points[i][1];
            }
        }
        return arrows;
    }
}

/***
 * 이 문제는 풍선의 처음과 끝이 주어졌을때 최소의 화살로 풍선을 다 터트리는것이다.
 *
 * 일단 int[][]를 sort한다.
 * 그리고 맨처음 원소의 두번째 값을 비교하기 위해 prevSecond로 해둔다.
 * for문을 돌릴건데 prevSecond와 다음 points의 첫번째 값을 비교한다.
 * prevSecond가 다음포인트의 첫번째 값보다 작거나 같으면 독립적인것이기에 arrows를 +1한다.
 * 그리고 prevSecond를 points[i][1]값으로 업데이트한다.
 * 다 돌린 후 arrows를 반환한다.
 */