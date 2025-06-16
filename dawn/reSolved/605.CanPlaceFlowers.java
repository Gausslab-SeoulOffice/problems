/*
605. Can Place Flowers

You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.


Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: true

Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
 */

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            boolean left = (i == 0) || (flowerbed[i - 1] != 1);
            boolean right = (i == flowerbed.length - 1) || (flowerbed[i + 1] != 1);
            if (left && right && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        if (n <= 0) {
            return true;
        } else {
            return false;
        }
    }
}

/***
 * 이 문제는 꽂을 심을 건데 0인 곳에 심을 수 있고, 바로 옆은 안된다는 것이다.
 *
 * for문을 돌리면서 심으려는 꽃을 다 심을 수 있는지 확인해야한다.
 * 일단 왼쪽이 가능한 경우는 맨 처음 인덱스이거나, 내 위치에서 왼쪽인 i-1이 1이 아닌지 확인하면 된다.
 * 오른쪽이 가능한 경우는 맨 마지막 인덱스이거나, 내 위치에서 오른쪽인 i+1이 1이 아닌지 확인하면 된다.
 * 그리고 지금 내가 있는 위치가 0이여야한다.
 * 세가지를 다 만족시키는 경우만 가능하기에 그런 경우에 flowerbed[i]에 심는다 가정해서 1로 변경해주고 n--로 갯수를 줄여주게 된다.
 * for문을 다 돌린 후 n을 확인했을때 0보다 작거나 같으면 원하는 만큼 다 심었을테니 true를 반환하고, 그게 아니라면 false를 반환한다.
 */