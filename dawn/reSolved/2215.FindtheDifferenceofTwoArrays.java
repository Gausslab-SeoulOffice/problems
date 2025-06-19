/*
2215. Find the Difference of Two Arrays

Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
Note that the integers in the lists may be returned in any order.


Example 1:
Input: nums1 = [1,2,3], nums2 = [2,4,6]
Output: [[1,3],[4,6]]
Explanation:
For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums1. Therefore, answer[1] = [4,6].

Example 2:
Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
Output: [[3],[]]
Explanation:
For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
Every integer in nums2 is present in nums1. Therefore, answer[1] = [].
 */

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }

        for (int num : set1) {
            if (!set2.contains(num)) {
                result.get(0).add(num);
            }
        }

        for (int num : set2) {
            if (!set1.contains(num)) {
                result.get(1).add(num);
            }
        }
        return result;
    }
}

/***
 * 이 문제는 차집합을 구하는 문제이다.
 * nums1에는 있는데, nums2에는 없는 숫자의 배열, nums2에는 있는데 nums1에는 없는 숫자의 배열을 반환하라는 문제이다.
 *
 * 일단 중복을 제거하기 위해 set으로 각 원소들의 집합을 구해둔다.
 * 그리고 nums2에는 없는 nums1의 값을 set1에서 찾아서 result.get(0)에 넣어준다.
 * 이후 nums1에는없는 nums2의 값을 set2에서 찾아서 result.get(1)에 넣어준다.
 * result를 반환하면 된다.
 */