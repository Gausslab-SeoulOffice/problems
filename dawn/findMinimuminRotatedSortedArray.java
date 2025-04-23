/*
153. Find Minimum in Rotated Sorted Array

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.


Example 1:
Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.

Example 2:
Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.

Example 3:
Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
 */

class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }
}

/***
 * 이 문제는 정렬된 배열이 어느정도 rotated 되어 있는데, 여기서 최소값을 찾으라는 문제이다.
 * 조건이 있다면 시간 복잡도는 O(log n)이다.
 *
 * 일단 무조건 정렬이 되어 있고, rotated 되어 있으니까 그것만 주의하면 된다.
 * 시작과 끝을 잡아주고, while로 반복문을 돌린다.
 * 중앙 값을 잡아주고, 중앙 값이 맨 마지막보다 크면 어딘가 부터 rotated되었다는 의미이기에, 중앙값 뒤부터 확인하면 된다.
 * 이제 그게 아니라면 정렬이 똑바로 된 부분이기에 끝값을 중앙값으로 옮겨서 확인하면 된다.
 * 반복문을 다 돌리고 나면 start 인덱스 값이 가장 작은 값이기 때문에 nums[start]하면 된다.
 */