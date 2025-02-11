/*
 * 45. Jump Game II
 *
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 *
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 *
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 */

class Solution {
    public int jump(int[] nums) {
        int currMax = nums[0];
        int jump = 0;
        int lastMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > lastMax) {
                jump++;
                lastMax = currMax;
            }
            currMax = Math.max(currMax, nums[i] + i);
        }
        return jump;
    }
}

/***
 *이 문제는 저번 점프 문제랑 비슷하다. 올라가는데 최소 만큼 뛰어서 올라가고 그 뛰는 숫자를 알고싶은거다.
 *
 * 일단 올라갈 수 있는 계단 수를 currMax로 설정해놓고, jump하는 횟수를 카운팅해야하니까 jump라는 변수를 만들어준다.
 * 지금 있는 칸수를 lastMax라고 이름 붙여주었다.
 * 그리고 계단의 갯수만큼 반복하면 되는데, 계단 개수가 아직 올라갈게 남았으면 일단 jump++를 한다. 그리고 지금 제일 많이 올라간 계단을 currMax로 업데이트 한다. currMax는 저번 코드랑 같다. 기존에 있는 currMax와 올라간 이후 갈 수 있는 최대를 비교해서 max 인걸 채택한다.
 * 이후 계단을 다 올라갔다면 jump를 return 시키면 된다.
 */