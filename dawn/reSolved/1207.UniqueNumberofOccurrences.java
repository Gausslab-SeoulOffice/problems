/*
1207. Unique Number of Occurrences

Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.


Example 1:
Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.

Example 2:
Input: arr = [1,2]
Output: false

Example 3:
Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true
 */

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer value : map.values()) {
            if (!set.add(value)) {
                return false;
            }
        }
        return true;
    }
}

/***
 * 이 문제는 각 숫자마다 나오는 횟수가 각각 다른지 확인하는 문제이다.
 *
 * map과 set을 사용할것이다.
 * 일단 map으로 나오는 숫자와 각각 몇번 나오는지 저장한다.
 * 이후 나온 횟수가 다 다른지 확인하기 위해 set을 사용할 것이다.
 * map.values()를 사용해서 set에 넣을때 중복이 없어야만 넣을 수 있다.
 * 중복 없이 넣어진다면 true, 그게 아니라면 false를 반환한다.
 */