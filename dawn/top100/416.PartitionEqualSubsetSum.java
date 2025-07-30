/*
416. Partition Equal Subset Sum

Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.


Example 1:
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 */

class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        if (totalSum % 2 != 0) {
            return false;
        }
        int target = totalSum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int currSum = target; currSum >= num; currSum--) {
                dp[currSum] = dp[currSum] || dp[currSum - num];
                if (dp[target]) {
                    return true;
                }
            }
        }
        return false;
    }
}

/***
 * 이 문제는 두 부분의 부분집합으로 나눴을때 두개의 합이 같은지 구하는 문제이다.
 *
 * 일단 집합의 전체 합을 구한다.
 * 그리고 2로 나눴을때 나머지가 나오면 딱 절반으로 나눌 수 없다는 의미이기에 바로 false를 반환한다.
 * 그리고 절반의 값을 target으로 지정한다.
 * dp는 그 수를 만들 수 있는지 확인하는 배열이다.
 * 0은 무조건 만들 수 있기 때문에 true이다.
 * 그리고 가지고 있는 nums를 가지고 확인하면 된다.
 * 현재 만들어가야하는 수는 target이고 가지고 있는 수는 num이다.
 * dp[currSum]을 확인하는 방법은 dp[currSum]이 되거나 가지고 있는 수를 뺀 값이 되는지 확인하는 것이다.
 */