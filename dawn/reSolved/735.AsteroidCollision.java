/*
735. Asteroid Collision

We are given an array asteroids of integers representing asteroids in a row. The indices of the asteriod in the array represent their relative position in space.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.


Example 1:
Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

Example 2:
Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.

Example 3:
Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 */

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            boolean alive = true;
            while (!stack.isEmpty() && compute(stack.peek(), asteroid)) {
                int top = stack.peek();
                if (Math.abs(top) < Math.abs(asteroid)) {
                    stack.pop();
                } else if (Math.abs(top) == Math.abs(asteroid)) {
                    stack.pop();
                    alive = false;
                    break;
                } else {
                    alive = false;
                    break;
                }
            }
            if (alive) {
                stack.push(asteroid);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

    private boolean compute(int first, int second) {
        if (first > 0 && second < 0) {
            return true;
        } else {
            return false;
        }
    }
}

/***
 * 이 문제는 행성충돌 문제이다.
 *
 * 일단 비교해야하는게 + , -가 충돌하는 경우이다.
 * compute라는 함수로 비교하게 된다.
 * 첫번째 수는 양수, 두번째 수는 음수인 경우엔 true이고, 그게 아니면 서로 반대방향으로 넘어가기때문에 false가 된다.
 * 그리고 -가 계속 크면 계속 살아있게 된다.
 * 이게 살아있는지 확인하려면 alive라는 변수를 선언해준다.
 * stack에 쌓을건데, 일단 양수 음수 순으로 들어오는지, stack이 비어있지 않은지 확인한다.
 * 그리고 compute도 true로 들어오게 되면 이제 계산해야한다.
 * 만약 그 전 값보다 asteroid가 더 크면 이 전 값이 사라지게 된다.
 * stack.pop()으로 삭제하게 된다.
 * 그리고 계속 계산하게 된다.
 * 만약 그 전 값이랑 asteroid가 같으면 둘 다 사라져야한다.
 * stack.pop()으로 이전값을 삭제하고, alive도 false로 변경하고 break로 끝낸다.
 * 만약 그 전값이 asteroid보다 크면 asteroid만 사라지면 된다.
 * alive를 false로 변경하고 break로 끝낸다.
 * 그리고 alive라면 계속해서 해야하기때문에 stack에 넣어야한다.
 * 다 한 뒤엔 int[]로 넣어주고 반환하면 된다.
 */