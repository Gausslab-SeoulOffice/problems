/*
128. Longest Consecutive Sequence

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.


Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

Example 3:
Input: nums = [1,0,1,2]
Output: 3
 */

class Solution {
    public int longestConsecutive(int[] nums) {
        int longestLength = 1;
        int currentLength = 1;
        Arrays.sort(nums);
        if (nums.length == 0) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                currentLength++;
                longestLength = Math.max(longestLength, currentLength);
            } else if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                currentLength = 1;
            }
        }
        return longestLength;
    }
}

/***
 * 이 문제는 순차적으로 나오는 배열의 길이가 제일 긴 걸 반환하라는 문제이다.
 *
 * 일단 제일 긴 길이를 저장해야하기 때문에 longestLength를 선언한다.
 * 현재 길이도 확인해야하기 때문에 currentLength를 선언한다.
 * 그리고 배열을 sort시킨다.
 * 여기서 한 번 놓친부분은 배열이 비어있을때를 생각을 못했지만, nums가 비어있으면 0을 return하도록 한다.
 * 그리고 이제 sort를 시켰을테니 인덱스 1부터 시작해서 그 전 값이랑 1차이가 나면 currentLength을 1 더하고, longestLength를 Math.max를 사용해서 업데이트 한다.
 * 숫자가 같으면 그냥 넘어가고, 그게 아니면 이제 currentLength를 1로 한다. 최종적으로 longestLength를 반환하면 된다.
 */