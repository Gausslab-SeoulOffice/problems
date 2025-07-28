/*
72. Edit Distance

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character

Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 */

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] result = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            result[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            result[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    result[i][j] = result[i - 1][j - 1];
                } else {
                    result[i][j] = 1 + Math.min(result[i - 1][j - 1], Math.min(
                            result[i][j - 1], result[i - 1][j]));
                }
            }
        }

        return result[m][n];
    }
}

/***
 * 이 문제는 word1을 word2로 변경할때 최소의 경우로 변경하는 수는 몇인지 구하는 문제이다.
 *
 * 일단 result[i][j]를 선언한다.
 * i를 j로 변경하는데 드는 횟수를 저장하는 것이다.
 * 없는 문자열에서 word2로 가려면 추가해주면 되기때문에 i만큼 횟수가 되고, word1에서 빈 문자열로 가려면 삭제하면 되기 때문에 i만큼 횟수가 추가 된다.
 * 이제 word1과 word2가 다 비어있지 않고 실제 단어가 있다면 확인해야한다.
 * 들어있는 문자가 같다면 result[i-1][j-1]과 같은 횟수가 될 것이다.
 * 문자가 다르면 이제 더 작은 횟수를 비교해야한다.
 * 삽입, 삭제, 교체 중 가장 작은 횟수를 가지고 오고 그거에 +1을 해주면 된다.
 * 이후 result[m][n]을 반환하면 된다.
 */