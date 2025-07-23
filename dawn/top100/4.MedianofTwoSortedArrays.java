/*
4. Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).


Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] merged = new int[len1 + len2];
        int k = 0;
        for (int i = 0; i < len1; i++) {
            merged[k++] = nums1[i];
        }
        for (int i = 0; i < len2; i++) {
            merged[k++] = nums2[i];
        }
        Arrays.sort(merged);

        int total = merged.length;
        if (total % 2 == 1) {
            return (double) merged[total / 2];
        } else {
            int middle1 = merged[total / 2 - 1];
            int middle2 = merged[total / 2];
            return ((double) middle1 + middle2) / 2.0;
        }
    }
}

/***
 * 이 문제는 nums1과 nums2가 주어졌을때 정렬이후 중간 값을 가지고 오는것이다.
 * 짝수이면 두개의 평균을 가지고 오면 된다.
 *
 * 일단 merged에다가 nums1과 nums2를 가지고 와서 합쳐준다.
 * 이후 Arrays.sort를 이용해서 정렬해준다.
 * 그리고 홀수개라면 가운데 숫자를 반환해준다.
 * 짝수개라면 가운데 있는 두개의 숫자를 가지고 와서 더한 후 2로 나눠서 평균을 구해준다.
 */