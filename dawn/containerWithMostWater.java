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
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            maxWater = Math.max(maxWater, (right - left) * Math.min(height[left], height[right]));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
}

/***
 * 최대 물의 양을 찾아내는 문제이다.
 * 물의 양은 높이와 너비를 곱해서 나오는 것이고, 오른쪽 왼쪽을 나눠서 계산하면 된다.
 *
 * 일단 최대 물의 양을 계속 업데이트 하면서 구할것이기 때문에, maxWater라는걸 선언한다.
 * 그 후엔 왼쪽 오른쪽을 계산해가면서 업데이트 할것이다.
 * 일단 maxWater은 너비인 right-left와 높이를 곱해야하는데, hegith[left], height[right]중에 더 낮은걸 기준으로 된다.
 * 그리고 왼쪽보다 오른쪽이 더 높으면 left를 오른쪽으로 옮겨주게된다.
 * 반대로 오른쪽이 더 낮으면 right를 왼쪽으로 옮겨주게 된다.
 * 이후 가장 컸던 maxWater를 return 해주면 된다.
 */