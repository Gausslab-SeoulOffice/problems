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
                int mid = (left + (right - left) / 2);
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
 * 이 문제는 spells를 돌아가면서 potions에 곱해서 나온 값들이 success보다 큰게 몇개가 있는지 list에 담아서 반환하라는 문제이다.
 *
 * 일단 potions가 정렬이 안되어 있으니까 정렬을 시킨다.
 * 이후에 spells를 한개씩 선택하고 potions 중에 중간을 가져온다.
 * 중간에서 가지고 온 값을 이용해서 spell * potions[mid]를 했을때 success 값과 비교한다.
 * 내 값이 더 크면 왼쪽에 있는 값중에 더 넘을 수 있는 값이 있는지 확인해야하니까 right를 mid-1로 옮긴후에 검색한다.
 * 내 값이 더 작으면 오른쪽으로 이동해서 넘을 수 있는 값이 있는지 확이애햐하니까 left를 mid=1로 옮긴후에 검색한다.
 * 이게 다 끝났으면 left를 기준으로 더 큰값들이 있을 예정이다.
 * 갯수를 확인해야하니까 potions의 갯수에서 left만큼 빼준다.
 * 그 값을 result[i]에 넣어서 result를 반환한다.
 */