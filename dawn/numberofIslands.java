/*
200. Number of Islands

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.


Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 */

class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = 0; i< rows; i++){
            for(int j =0; j< cols; j++){
                if(grid[i][j] == '1'){
                    findIands(i, j, rows, cols, grid);
                    result++;
                }
            }
        }
        return result;
    }
    private void findIands(int i, int j, int rows, int cols, char[][] grid){
        if(i<0 || j<0 || i>=rows|| j>=cols){
            return;
        }
        if(grid[i][j]=='1'){
            grid[i][j]='#';
            findIands(i-1, j, rows, cols, grid);
            findIands(i, j+1, rows, cols, grid);
            findIands(i+1, j, rows, cols, grid);
            findIands(i, j-1, rows, cols, grid);
        }else{
            return;
        }
    }
}

/***
 * 이 문제는 섬이 몇 개가 있는지 묻는것이다.
 * 물은 0, 섬은 1이라고 생각하면 되고, 1이 연결되어있으면 한개의 섬이다.
 *
 * 일단 내가 있는 위치가 i,j라고 생각하면 된다. 만약에 grid[i][j]가 1이라면 섬 시작이라는 것이다.
 * 그 위치에서 상하좌우를 살피는 것이다.
 * 상하좌우를 살피는 함수는 findIands라고 생각하면 된다.
 * 일단 범위 안에 있어야하기 때문에, i<0 || j<0 || i>=rows|| j>=cols 이걸로 체크를 한다.
 * 그리고 내가 간 섬은 이미 확인했으니까 #으로 바꿔준다.
 * 그리고 그 섬이 다 확인 되면 result++을 해준다.
 * 그럼 다음 for문으로 넘어가도 이미 갔던곳은 #이 되어 있기때문에 그냥 넘어갈 수 있게 된다.
 */