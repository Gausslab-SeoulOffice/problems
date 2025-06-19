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
        int total = 0;
        int leftSum = 0;

        for (int num : nums) {
            total += num;
        }

        for (int i = 0; i < nums.length; i++) {
            int rightSum = total - nums[i] - leftSum;
            if (rightSum == leftSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}

/***
 * 이 문제는 왼쪽의 합과 오른쪽 합이 같을 수 있는 pivot의 인덱스를 찾는 문제이다.
 *
 * 일단 전체 값을 알아야하기 때문에 nums에 있는 수를 다 더해준다.
 * 그리고 rightSum을 찾아낸다.
 * 전체 값에서 왼쪽값과 현재값을 빼면 된다.
 * 만약에 rightSum과 leftSum이 같다면 현재 있는 위치의 인덱스를 반환하면 된다.
 * 그게 아니라면 leftSum에 현재 내 값을 추가하고 넘어가야한다.
 * for문을 다 돌았는데 답이 없다면 -1을 반환한다.
 */