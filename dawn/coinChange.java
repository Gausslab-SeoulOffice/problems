/*
322. Coin Change

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.


Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Example 3:
Input: coins = [1], amount = 0
Output: 0
 */

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] minCoins = new int[amount + 1];
        Arrays.fill(minCoins, amount + 1);
        minCoins[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    minCoins[i] = Math.min(minCoins[i], 1 + minCoins[i - coin]);
                }
            }
        }
        return minCoins[amount] != amount + 1 ? minCoins[amount] : -1;
    }
}

/***
 * 이 문제는 가지고 있는 coins 배열을 가지고 amount를 만들때 가장 최소의 수로 만들고, 그 수를 반환하는 문제이다.
 *
 * 일단 minCoins를 선언한다 0~amount까지 최소의 경우의 수를 담을 배열이라고 생각하면 된다.
 * 그리고 일단 초기화를 시키기 위해 amount+1로 최대값을 넣어준다.
 * 그리고 0을 만드는 방법은 0이기때문에 minCoins[0] = 0을 넣는다.
 * 그리고 1부터 시작하게된다.
 *  i-coin>=0이면 coin으로 인해 경우의수를 계산할 수 있는것이기에
 * minCoins에 최소값을 넣어준다.
 * 그 전에 있던 값과 비교해서 1+이전의 경우의수를 넣어준다.
 * 경우의 수를 다 찾았으면 확인만 하면된다.
 * minCoins[amount]가 처음 초기화 시킨 amount+1이랑 다르면 경우의 수가 있다는 의미이기 때문에 minCoins[amount]를 반환하고, 그게 아니라면 -1을 반환한다.
 */