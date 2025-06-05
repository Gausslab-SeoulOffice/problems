/*
374. Guess Number Higher or Lower

We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

You call a pre-defined API int guess(int num), which returns three possible results:

-1: Your guess is higher than the number I picked (i.e. num > pick).
1: Your guess is lower than the number I picked (i.e. num < pick).
0: your guess is equal to the number I picked (i.e. num == pick).
Return the number that I picked.


Example 1:
Input: n = 10, pick = 6
Output: 6

Example 2:
Input: n = 1, pick = 1
Output: 1

Example 3:
Input: n = 2, pick = 1
Output: 1
 */

/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 0;
        int end = n;
        while (start <= end) {
            int mid = (start + (end - start) / 2);

            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == 1) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}

/***
 * 이 문제는 이진 트리가 있다고 칠때 내가 선택한 숫자가 뽑은 숫자보다 크면 -1이 반환되고 같으면 0, 작으면 1이 반환되는 문제이다. 이때 pick한 숫자를 구해야하는 문제이다.
 *
 * 일단 중간의 숫자를 물어보는게 좋다.
 * 중간을 구하기 위해서 시작과 끝 인덱스을 알아야한다.
 * 중간은 start + (현재) 끝 값을 해야한다.
 * 그리고 guess를 한다.
 * 0이라면 pick한 숫자랑 같다는 의미이기에 mid를 반환하면 된다.
 * 1이라면 mid가 더 작다는 의미이기에 mid 다음을 시작값으로 옮겨준다.
 * -1이라면 mid가 더 크다는 의미이기에 mid 이전 값을 시작값으로 옮겨준다.
 */