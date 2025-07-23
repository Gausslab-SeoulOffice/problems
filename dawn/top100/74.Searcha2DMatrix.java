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
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}

/***
 * 이 문제는 2D가 주어졌을땐 O(long(m*n))안에 target을 찾으면 true, 못찾으면 false를 반환하는 문제이다.
 *
 * 일단 순차적으로 적혀있기 때문에 row는 0으로 col은 제일 끝으로 설정해준다.
 * 그리고 matrix[row][col]을 하게 되는데 target과 같으면 true를 반환한다.
 * 만약에 지금 값이 target보다 크면 값을 줄이기 위해서 col를 줄여나간다.
 * 더 작다면 키워야하기때문에 row를 증가시켜준다.
 * 찾을때까지 하다가 값이 없으면 false를 반환한다.
 */