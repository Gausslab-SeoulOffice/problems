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
            int mid = start + (end - start) / 2;
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
 * 이 문제는 binary search로 원하는 값을 찾는 문제이다.
 *
 * 일단 시작값을 0으로 하고, 끝값은 n으로 한다.
 * 그리고 중간값을 찾아서 그걸 guess(mid)로 값을 찾는다.
 * 0이면 원하는 값을 찾은것이기 때문에 mid를 반환한다.
 * 1이면 찾는 값보다 작았다는 의미이기에 start를 mid+1로 올려준다.
 * -1이면 찾는 값보다 컸다는 의미기이에 end를 mid-1로 내려준다.
 */