/*
34. Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.


Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] answer = new int[] { -1, -1 };
        answer[0] = search(nums, target, true);
        answer[1] = search(nums, target, false);
        return answer;
    }

    private int search(int[] nums, int target, boolean firstIndex) {
        int start = 0;
        int end = nums.length - 1;
        int targetIndex = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int element = nums[mid];
            if (target > element) {
                start = mid + 1;
            } else if (target < element) {
                end = mid - 1;
            } else {
                targetIndex = mid;
                if (!firstIndex) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return targetIndex;
    }
}

/***
 * 이 문제는 target을 찾는 문제이다.
 *
 * 배열로 찾아야하기 때문에 일단 -1, -1로 시작한다.
 * 그리고 search함수를 사용해서 answer[0], answer[1]을 각각 찾는다.
 * search함수는 인덱스를 사용해서 찾는다.
 * mid를 계산해서 중간 값을 이용한다.
 */