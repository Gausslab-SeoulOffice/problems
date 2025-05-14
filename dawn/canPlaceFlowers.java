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
            boolean left = i == 0 || flowerbed[i - 1] == 0;
            boolean right = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;

            if (left && right && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
}

/***
 * 이 문제는 화단이 있을때 양 옆에 꽃이 없어야하고, n만큼 꽃을 심어야하는데 가능한지 묻는 문제이다.
 *
 * 일단 for문을 돌려서 확인하는데, left, right를 만들어서 먼저 확인해준다.
 * 그리고 left와 right가 true여야하고, 지금 있는 위치가 0이여야한다.
 * 이게 3개가 다 맞다면 flowerbed[i]를 1로 바꿔주고, n을 카운트 해준다.
 * for문을 다 돌았을때, n이 0보다 작거나 같으면 true를 반환하고, 아니면 false를 반환한다.
 */