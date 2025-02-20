/*
54. Spiral Matrix

Given an m x n matrix, return all elements of the matrix in spiral order.


Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = col - 1;
        int top = 0;
        int bottom = row - 1;
        List<Integer> result = new ArrayList();

        while (result.size() < row * col) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            for (int t = top; t <= bottom; t++) {
                result.add(matrix[t][right]);
            }
            right--;
            if (bottom < top) {
                break;
            }
            for (int r = right; r >= left; r--) {
                result.add(matrix[bottom][r]);
            }
            bottom--;
            if (right < left) {
                break;
            }
            for (int b = bottom; b >= top; b--) {
                result.add(matrix[b][left]);
            }
            left++;
        }
        return result;
    }
}

/***
 * 이 문제는 왼쪽에서 오른쪽으로, 위쪽에서 아래쪽으로, 오른쪽에서 왼쪽으로, 아래쪽에서 윗쪽으로 숫자를 return하는 문제이다.
 *
 * 일단 인덱스 확인을 위해 row, col, left, right, top, bottom을 선언하고, 답을 저장할 수 있는 result를 선언한다.
 * 그리고 이제 while로 돌면서 추가할 것이다.
 * 일단 left -> right로 가는걸 확인한다. 맨 위에서부터 시작할거고, right까지 갔으면 top++로 한줄 내려온다.
 * 그리고top -> bottom으로 가는 걸 확인한다, 그리고right--로 옮겨준다.
 * 그리고 bottom이 top보다 작으면 멈춘다.
 * 계속해서 right -> left로 가는걸 확인한다. 그리고 한칸 울라가야해서 bottom--를 한다,
 * 그리고 right가 left보다 작으면 멈춘다.
 * 계속해서 bottom -> top으로 가는걸 확인한다. 그리고 left++로 옮겨준다.
 * 다 돌리면 result를 return한다.
 */