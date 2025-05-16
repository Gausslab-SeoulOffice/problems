/*
11. Container With Most Water

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.



Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1
 */

class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}

/***
 * 이 문제는 가장 많은 물을 담을 수 있는 그 양을 출력하라는 문제이다.
 *
 * 일단 가장 많은 양을 저장하는 변수를 max로 선언하고 left,right를 이용해서 그 양을 확인할거라 선언해둔다.
 * left<right인 경우에 반복문을 실행할 예정이다.
 * max는 항상 업데이트 하게 된다.
 * 현재의 max와 지금 있는 위치에서 가로 세로를 곱해서 넓이를 구한 값을 비교해서 더 큰 값을 max에 넣는다.
 * 그리고 다음으로 넘어가서 확인해야하기 때문에 높이를 비교하게 된다.
 * height[left]가 height[right]보다 작으면 다음으로 넘어가야하기때문에 left를 증가시키고, 그게 아니라면 right를 감소시킨다. 반복문을 다 돌리면 가장 큰 양이 max에 담겨있기 때문에 max를 반환하면 된다.
 */