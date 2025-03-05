/*
219. Contains Duplicate II

Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.


Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false

 */

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num) && i - map.get(num) <= k) {
                return true;
            }
            map.put(num, i);
        }
        return false;
    }
}

/***
 * 이 문제는 nums[i]==nums[j]를 찾고 그 인덱스의 차이가 k보다 작거나 같으면 true, 아니라면 false를 반환하는 문제이다.
 *
 * 일단 map에다가 이 숫자와 인덱스를 입력하기 위해 선언해준다.
 * 그리고 숫자 한개씩 비교하는것이다.
 * 숫자를 입력받아두고, 그게 map안에 있으면 그 전에 기록된 수가 있다는건데, 그 기록된 수와 지금의 인덱스의 차이가 k보다 작으면 true를 반환하면 된다.
 * map안에 숫자가 없다면 처음 나오는 것이기 때문에 put으로 map안에 그 숫자와 인덱스를 넣으면 된다.
 */