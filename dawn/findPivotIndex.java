/*
724. Find Pivot Index

Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.


Example 1:
Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11

Example 2:
Input: nums = [1,2,3]
Output: -1
Explanation:
There is no index that satisfies the conditions in the problem statement.

Example 3:
Input: nums = [2,1,-1]
Output: 0
Explanation:
The pivot index is 0.
Left sum = 0 (no elements to the left of index 0)
Right sum = nums[1] + nums[2] = 1 + -1 = 0
 */

class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        int leftSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if (rightSum == leftSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}

/***
 * 이 문제는 기준점을 기준으로 그 전의 원소들의 합과, 그 이후 원소들의 합이 같은 지점을 찾은 경우 그 기준의 인덱스를 반환하는 문제이다.
 *
 * 일단 모든 값을 더한 totalSum을 선언하고, 모든 원소들의 합을 넣어준다.
 * 그리고 어떤 인덱스를 기준으로 왼쪽의 값을 더한 걸 나타내는 leftSum을 선언한다.
 * 이제 반복문으로 인덱스를 옮기면서 rightSum 값을 추가해주면서 비교할것이다.
 * 일단 rightSum은 총합에서 왼쪽합을 빼고 현재 기준값도 빼면 된다.
 * 만약에 rightSum이랑 leftSum이랑 같으면 현재 인덱스를 반환하면 된다.
 * 그리고 그 값이 아니라면 인덱스를 다음것으로 옮길예정이기 때문에 leftSum에 현재 값을 추가해준다.
 * 반복문을 다 돌렸는데 아무것도 리턴하지 않으면 기준값이 없다는 의미이기 때문에 -1을 리턴한다.
 */