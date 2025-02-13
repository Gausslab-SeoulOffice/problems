/*
42. Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9
 */

class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int water = 0;
        int leftMax = height[left];
        int rightMax = height[right];

        while (left < right) {
            if (height[left] < height[right]) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
            }
        }
        return water;
    }
}

/***
 * 이 문제는 둑을 쌓고 그 안에 채워진 물의 양을 찾는 것이다.
 * 생각해볼만한건 오른쪽 둑과 왼쪽둑의 길아 차이이다.
 *
 * 일단 이 둑을 끝까지 탐색해야하기때문에 왼쪽 인덱스가 오른쪽 인덱스보다 작을때까지만 탐색한다.
 * 인덱스는 left, right로 설정하고, 이 둑의 최대 높이를 찾아서 계산해야하기 때문에 leftMax, rightMax를 설정해둔다. 이건 각각 둑의 높이이기에 height를 이용한다.
 * 이후 이 둑의 높이에 따라 다음 스탭으로 가는 방법이 반대이기에 나눠준다.
 * 더 낮은 둑을 옮길거고, 왼쪽이 더 낮다면 left++로 일단 인덱스를 옮겨준다. 그리고 둑의 높이중 높은걸 채택해주어야한다.
 * leftMax를 max를 이용하여 원래있던 leftMax와 인덱스를 옮긴 둑의 높이를 비교해 더 높은걸로 채택하고, 물의 양을 추가해준다.
 * 물의 양은 높은 둑의 높이에서 지금 있는 둑의 높이를 빼면 물의 양이 나올것이다.
 * 오른쪽도 비슷하다. 다만 인덱스를 옮길때 right--로 왼쪽으로 옮겨주는 방식을 사용한다.
 * 이후 총 나온 water를 return해주면 된다.
 */