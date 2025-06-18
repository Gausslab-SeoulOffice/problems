/*
1679. Max Number of K-Sum Pairs

You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.


Example 1:
Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.

Example 2:
Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.
 */

class Solution {
    public int maxOperations(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        int count = 0;
        Arrays.sort(nums);

        while (start < end) {
            if (nums[start] + nums[end] == k) {
                count++;
                start++;
                end--;
            } else if (nums[start] + nums[end] > k) {
                end--;
            } else {
                start++;
            }
        }
        return count;
    }
}

/***
 * 이 문제는 가지고 있는 배열에서 k를 만들 수 있는 경우의 수가 얼마나 있는지 확인하는 문제이다.
 * 단 쌍을 찾은 경우 그 숫자를 제외한 후 찾아야한다.
 *
 * 일단 시작과 끝을 선언해둔다.
 * 그리고 쌍을 찾으면 갯수를 세야하기 때문에 count라는 변수도 선언해둔다.
 * 그리고 차례대로 찾아야하기 때문에 sort로 정렬을 먼저 시켜준다.
 * while문을 돌려서 찾을 것이다.
 * 맨 처음과 맨 마지막 숫자들을 더해서 k가 나오는지 확인한다.
 * 정렬을 시켰기 때문에 순서대로가 가능한것이다.
 * k가 나온다는 의미는 갯수를 증가시켜야하기때문에 count++을 하고, 제외시켜야하기때문에 start는 증가, end는 감소로 제외시켜준다.
 * k보다 크다는 의미는 큰 숫자를 줄여줘야한다는 것이기에 end를 감소시켜준다.
 * K보다 작다는 의미는 작은 숫자를 키워줘야한다는 것이기에 start를 증가시켜준다.
 * while을 다 돌리면 쌍들을 찾은 갯수만큼 count가 되어 있기에 count를 반환시켜준다.
 */