/*
2300. Successful Pairs of Spells and Potions

You are given two positive integer arrays spells and potions, of length n and m respectively, where spells[i] represents the strength of the ith spell and potions[j] represents the strength of the jth potion.

You are also given an integer success. A spell and potion pair is considered successful if the product of their strengths is at least success.

Return an integer array pairs of length n where pairs[i] is the number of potions that will form a successful pair with the ith spell.


Example 1:
Input: spells = [5,1,3], potions = [1,2,3,4,5], success = 7
Output: [4,0,3]
Explanation:
- 0th spell: 5 * [1,2,3,4,5] = [5,10,15,20,25]. 4 pairs are successful.
- 1st spell: 1 * [1,2,3,4,5] = [1,2,3,4,5]. 0 pairs are successful.
- 2nd spell: 3 * [1,2,3,4,5] = [3,6,9,12,15]. 3 pairs are successful.
Thus, [4,0,3] is returned.

Example 2:
Input: spells = [3,1,2], potions = [8,5,8], success = 16
Output: [2,0,2]
Explanation:
- 0th spell: 3 * [8,5,8] = [24,15,24]. 2 pairs are successful.
- 1st spell: 1 * [8,5,8] = [8,5,8]. 0 pairs are successful.
- 2nd spell: 2 * [8,5,8] = [16,10,16]. 2 pairs are successful.
Thus, [2,0,2] is returned.
 */

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];
        Arrays.sort(potions);

        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            int left = 0;
            int right = m - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long answer = (long)spell * potions[mid];
                if (answer >= success) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            result[i] = m - left;
        }
        return result;

    }
}


/***
 * 이 문제는 spells를 곱해서 success보다 큰게 몇개가 나오는지 배열로 반환하라는 문제이다.
 *
 * 일단 potions을 정렬해둔다.
 * 그리고 binarySearch를 사용할거기때문에 mid를 구해준다.
 * 곱한 값을 answer로 해두고 그게 success보다 큰지 확인해서 left, right를 옮겨준다.
 * 반복문이 끝나면 갯수를 세어주어야하기 때문에 m-left를 해준다.
 * 마지막으로 result를 반환한다.
 */