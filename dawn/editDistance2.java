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
        int[][] result = new int[word1.length()+1][word2.length()+1];

        for(int i=0; i<=word1.length(); i++){
            result[i][0] = i;
        }
        for(int j= 0; j<=word2.length(); j++){
            result[0][j] = j;
        }

        for(int i=1; i<= word1.length(); i++){
            for(int j =1; j<=word2.length(); j++){
                if(word1.charAt(i-1)== word2.charAt(j-1)){
                    result[i][j] = result[i-1][j-1];
                }else{
                    result[i][j] = 1+Math.min(
                            result[i-1][j-1], Math.min(result[i-1][j], result[i][j-1])
                    );
                }
            }
        }
        return result[word1.length()][word2.length()];
    }
}

/***
 * 이 문제는 word1을 word2로 바꾼눈ㄴ데 필요한 최소 연산 횟수를 구하는 문제이다.
 *
 * word2가 빈 문자열이면 모두 삭제해야 하기때문에 result[i][0]은 i로 설정한다.
 * word1이 빈 문자열이면 모두 삽입해야 하기때문에 result[0][j]는 j로 설정한다.
 * result[i][j] = restul[i-1][j-1];  문자가 같으면 아무 연산 필요 없다.
 * 이건 word1[i-1]과 word2[j-1]가 다른 경우에는, 삭제, 삽입, 교체 3가지 연산 중 최소 비용을 선택한 후에 +1을 해준다.
 */