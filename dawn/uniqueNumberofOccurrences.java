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
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for(Integer count: map.values()){
            if(!set.add(count)){
                return false;
            }
        }
        return true;
    }
}

/***
 * 이 문제는 숫자들이 나온 횟수를 세서 중복되는 횟수가 있으면 false, 나온 횟수가 다 다르면 true를 반환하는 문제이다.
 *
 * 일단 나온 횟수를 세야하기 때문에 map을 한개 선언해준다.
 * 그리고 중복을 확인하기 위해 set도 한개 선언해준다.
 * 그리고 모든 숫자를 돌아가면서 카운팅 해서 map에 넣어준다.
 * 그 이후 set에 넣을건데, 중복이면 들어가지 않기때문에 add가 불가능하면 이미 있다는 의미이기에 false를 반환하고, 그게 아니라면 true를 반환한다.
 */