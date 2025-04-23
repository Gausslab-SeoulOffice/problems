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
 * 이 문제는 정렬되어 있는 배열에서 target의 첫 번째 나온 인덱스, 두 번째 나온 인덱스를 반환하라는 문제이다.
 * 조건은 O(log n)이라는 조건이 있다.
 *
 * 일단 값은 무조건 int[]가 나와야하기 때문에 함수를 한 개 더 작성한다.
 * 반으로 나눠서 찾아야 조건에 부합하기 때문에 start, end를 각각 선언해준다.
 * 그리고 while문으로 반복문을 돌리면서 찾게된다.
 * 가운데 있는 값을 mid로 찾는다.
 * 그리고 그 가운데 값을 가지고 비교를 해서 찾으려는 값이 값보다 크면 start를 옮기고, 작으면 end를 옮기게 된다.
 * 첫 번째 인덱스이면 두 번째 인덱스를 찾아야하기 때문에 값을 줄인걸 계속 이용하기 위해 mid를 업데이트 시켜준다.
 */