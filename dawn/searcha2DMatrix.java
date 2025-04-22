/*
74. Search a 2D Matrix

You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.


Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}

/***
 * 이 문제는 matrix 배열 안에 target이라는 숫자가 들어있는지 확인하는 문제이다.
 * 제약 조건은 시간복잡도가 O(log(m*n))이라는 것인데, 이건 반으로 쪼개서 문제를 확인하라는 것이다.
 *
 * 일단 row는 0으로 초기화 해두고 col은 맨 끝에 있는걸로 설정해둔다.
 * 그리고 while로 반복해서 찾을때까지 돌릴예정이다.
 * 지금 가지고 있는게 target이랑 같으면 true를 하고, 그보다 작으면 row를 더해준다.
 * 일단 큰 수가 나올때까지 row를 올려주다가, 큰 수가 나오게 되면 그 줄 안에 범위가 속해있다는 것을 의미한다.
 * 그러면 이제 가로로 이동하면 되는데 col이 맨 오른쪽에 있으니까 왼쪽으로 갈 수 있게 col--를 하면된다.
 * 반복문을 다 돌렸는데 나오지 않았다면 숫자가 없는것이기에 false를 반환한다.
 */