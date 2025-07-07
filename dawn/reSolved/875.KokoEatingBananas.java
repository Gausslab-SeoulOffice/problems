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
        int max =0;
        int min =1;

        for(int pile : piles){
            max = Math.max(max, pile);
        }

        while(min < max){
            int mid = min + (max -min)/2;
            if(canEat(piles, mid, h)){
                max = mid;
            }else{
                min = mid+1;
            }
        }
        return min;
    }

    private boolean canEat(int[] piles, int k, int h){
        int hours =0;
        for(int pile : piles){
            hours += (pile + k - 1) / k;
        }
        return hours <= h;
    }
}

/***
 * 이 문제는 h시간 안에 모든 piles를 다 먹어야하는데 1시간에 먹을 수 있는 최소 수를 찾는 문제이다.
 *
 * 일단 찾고싶은 최소를 min으로 해둔다.
 * max도 설정해둔다.
 * max는 가장 큰 수가 될것이다.
 * 그리고 중간값부터 확인하면 된다.
 * canEat함수에서 시간내에 먹을 수 있는지 확인하는 것이다.
 * (pile + k -1) /k 는 pile/k를 오름차순으로 계산하는 방법이다.
 * 그렇게 하면 다 먹는 시간이 h를 넘지 않아야하기 때문에 boolean으로 반환해준다.
 * true라면 가능하기 때문에 먹는 수를 늘릴 수 있다.
 * max의 값을 mid로 줄여준다.
 * false라면 더 많이 먹어야하기 때문에 min을 mid로 늘려준다.
 * 이후 min을 반환하면 된다.
 */