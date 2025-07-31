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
                    minCoins[i] = Math.min(minCoins[i - coin] + 1, minCoins[i]);
                }
            }
        }
        return minCoins[amount] != amount + 1 ? minCoins[amount] : -1;
    }
}

/***
 * 이 문제는 가지고 있는 coins로 amount를 만들때 최소의 수로 만드는 방법을 구하는 문제이다.
 *
 * 일단 만들 수 있는 방법을 저장할 minCoins[]를 만든다.
 * 그리고 가장 큰 수로 채우기 위해서 amount+1값을 넣어준다.
 * 0을 만드는 방법은 0개이기 때문에 minCoins[0]값은 0을 지정한다.
 * 그리고 1부터 시작하는데 i-coin이 0보다 크거나 같은 경우에만 가능하다.
 * i-coin에 coin을 더하는 방법이기 때문에 minCoins[i-coin]의 경우의 수에 +1을 한 값고, minCoinis[i]의 값 중에 더 작은 값을 선택해서 minCoins[i]에 넣어준다.
 * 이후 반환할때 생각을 한 번 더 해야한다.
 * minCoins[amount]가 amount+1이라고 하면 만들 수 있는 숫자가 없었기 때문에 -1을 반환해야한다.
 * 즉, minCoins[amount]가 amount+1이 아니라고 하면 만들 수 있는 숫자가 있었다는 의미이기에 minCoins[amount]를 반환하고, 그게 아니라면 -1을 반환하면 된다.
 */