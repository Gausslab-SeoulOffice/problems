/*
48. Rotate Image

You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.



Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Example 2:
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

 */

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = temp;
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = i; j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}

/***
 * 이 문제는 가지고 있는 메트릭스를 90도 오른쪽 회전을 시키라는 문제이다.
 * 일단 생각해봐야하는건 90도를 오른쪽으로 돌리려면 어떤식으로 메트릭스가 움직이느냐인데,
 * 일단 상하를 뒤집는다. 그리고 x축 대칭을 한다. 이런 식으로 가면 된다.
 *
 * 일단 n이라는건 정해지기 때문에 선언을 해놓는다.
 * 그리고 상하를 뒤집는건 절반만 하면 되는 일이기에 i는 n/2만큼으로 설정하고, matrix[i][j] 와 matrix[n-i-1][j]를 위치를 바꿔준다.
 * 그리고 x축 대칭을 이뤄준다. x축 대칭이기에 j는 i로 시작한다. matrix[i][j]와 matrix[j][i]를 바꾸면 되는 것이다.
 */