/*
875. Koko Eating Bananas

Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.


Example 1:
Input: piles = [3,6,7,11], h = 8
Output: 4

Example 2:
Input: piles = [30,11,23,4,20], h = 5
Output: 30

Example 3:
Input: piles = [30,11,23,4,20], h = 6
Output: 23
 */

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        while (min < max) {
            int mid = min + (max - min) / 2;
            if (eat(piles, mid, h)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private boolean eat(int[] piles, int k, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k;
        }
        return hours <= h;
    }
}

/***
 * 이 문제는 h시간안에 먹어야하는 바나나를 다 먹어야하는데 한시간에 최소 몇개를 먹어야하는지 묻는 문제이다.
 *
 * 일단 최소 1개, 최대를 리스트의 원소 중 가장 큰걸 다 먹은 경우의 수이다.
 * 그리고 확인을 해야한다.
 * 최대와 최소 사이의 중간을 확인해서 시간안에 다 먹을 수 있는지 확인해서 다 먹을 수 있으면 최소 개수를 더 구할 수 있기때문에 max를 mid로 바꿔서 다시 계산한다.
 * 시간이 모자라면 먹는 양을 더 늘려야하기때문에 min을 mid+1로 늘려서 다시 계산한다.
 * 먹을 수 있는지 확인하는 함수를 eat로 만든다.
 * 만약 바나나가 7개이고 한시간에 3개씩 먹을수 있다고 하면 3시간이 걸리는것이다.
 * 그 계산은 (pile + k -1)/k 로 이루어진다.
 * 그 시간들을 모두 더해서 h보다 작거나 같으면 성공 넘으면 실패이다.
 */