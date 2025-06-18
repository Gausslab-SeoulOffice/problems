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
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left <= right) {
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
 * 이 문제는 최대 물의 양을 구하는 문제이다.
 *
 * 왼쪽 오른쪽으로 생각해서 제일 큰 물 양을 max로 업데이트 하는 방식이다.
 * 일단 왼쪽은 0, 오른쪽은 height-length-1로 선언해둔다.
 * 그리고 while문을 돌리게 된다.
 * max는 매번 업데이트를 먼저 해줘야한다.
 * 가지고 있던 max와 비교해준다.
 * 현재 있는 위치에서 물 양을 구해주는것이다.
 * 물양은 가로x세로 이기 때문에 가로인 right-left와 세로는 더 짧은 쪽은 선택해야하기때문에 Math.min을 이용한다.
 * 업데이트 이후에는 새로운 값을 구하기 위해 변경을 해야한다.
 * 더 큰 물 양을 구해야하기때문에 높이가 길어야한다.
 * 왼쪽이 오른쪽보다 높이가 높으면 오른쪽을 당겨와야하기때문에 right--를 시키고, 반대인 경우엔 왼쪽을 당겨와야하기 때문에 left++를 해주어야한다.
 * while문을 다 돌리면 max에 가장 큰 값이 업데이트 되어 있기때문에 max를 반환하면 된다.
 */