/*
73. Set Matrix Zeroes

Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.


Example 1:
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Example 2:
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 */

class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        HashSet<Integer> zeroRows = new HashSet<>();
        HashSet<Integer> zeroCols = new HashSet<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (zeroRows.contains(i) || zeroCols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

/***
 * 이 문제는 주면에 0이 있으면 가로세로줄은 다 0으로 바꿔달라는 것이다.
 * 일단 생각이 드는건 set을 이용한다는 것이다.
 *
 * 일단 길이들을 계속 사용해야할거 같으니 선언해준다.
 * 그리고 HashSet을 이용해서 가로 세로를 입력한다, matrix[i][j]가 0이라면 set에 그 줄이 몇번째 줄인지 추가한다.
 * 그리고 다시 한 번 확인해서 가로나 세로에 0이 있으면 matrix[i][j]을 0으로 바꿔주는것이다.
 * 근데 set말고 더 좋은 방법이 있을거 같다.
 */