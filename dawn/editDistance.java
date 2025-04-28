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
        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i<=m; i++){
            dp[i][0] = i;
        }

        for(int j =1; j<=n; j++){
            dp[0][j] = j;
        }

        for(int i = 1; i<=m; i++){
            for(int j =1; j<=n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(
                            dp[i-1][j-1],
                            Math.min(dp[i-1][j], dp[i][j-1])
                    );
                }
            }
        }
        return dp[m][n];
    }
}

/***
 * 이 문제는 word1에서 word2로 바꾸는 방법중에 최소 변경 수를 구하는 문제이다.
 *
 * 가능한 작업은 3개:
 * 삽입 (Insert)
 * 삭제 (Delete)
 * 교체 (Replace)
 * m : word1 길이, n : word2 길이, dp[i][j] = word1의 앞 i글자를 word2의 앞 j글자로 바꾸는 데 필요한 최소 연산 수이다.
 *
 * for (int i = 1; i <= m; ++i)
 *   dp[i][0] = i;
 * word2가 ""(빈 문자열)일 때는
 * word1의 모든 문자를 삭제(delete) 해야 함.
 *
 * for (int j = 1; j <= n; ++j)
 *   dp[0][j] = j;
 * word1이 ""(빈 문자열)일 때는
 * word2의 모든 문자를 삽입(insert) 해야 함.
 *
 * word1[i-1] == word2[j-1]면?
 * 두 글자가 같으니까, 아무 작업 필요 없음 → dp[i][j] = dp[i-1][j-1]
 * 다르면?
 * 3가지 선택 중 최솟값 + 1:
 * dp[i-1][j-1] : 교체 (replace)
 * dp[i-1][j] : 삭제 (delete)
 * dp[i][j-1] : 삽입 (insert)
 */