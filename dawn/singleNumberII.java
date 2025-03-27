/*
137. Single Number II

Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.


Example 1:
Input: nums = [2,2,3,2]
Output: 3

Example 2:
Input: nums = [0,1,0,1,0,1,99]
Output: 99
 */

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1)
                return entry.getKey();
        }
        return 0;
    }
}

/***
 * 이 문제는 1번만 나온 숫자를 찾는 문제이다.
 *
 * 일단 map을 만들어서 각 숫자와 그 횟수를넣는다.
 * 그 map entry를 가지고 와서 그 중에 value 가 1인걸 찾고, 그 key 값을 반환한다.
 */