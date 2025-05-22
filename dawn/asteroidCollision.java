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

            while (!stack.isEmpty() && !compute(stack.peek(), asteroid)) {
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
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;

    }

    private boolean compute(int first, int second) {
        return !(first > 0 && second < 0);
    }

}

/***
 * 이 문제는 소행성 충돌이다. 서로 다른 부호의 숫자들이 들어오는데, 서로 마주보는 방향으로 오면 충돌하게 되는데, 음수가 더 크면 작은게 사라지고, 남은 소행성의 배열을 반환하라는 문제이다.]
 *
 * 일단 소행성을 확인해야하기 때문에 stack을 선언한다.
 * 그리고 들어오는 행성을 한개씩 확인하는데, 충돌하는 경우는 (양수, 음수) 이 순서대로 들어오는게 문제가 된다.
 * 이것을 확인하기 위해 compute라는 함수를 만들어서 확인하면 된다.
 * 만약에 지금 들어와 있는 맨 위 숫자와 음수가 만나게 된다면, 이제 절대값으로 확인해야한다.
 * 음수가 더 크다면 현재 맨 위에 있는 소행성이 사라져야하기에 stack.pop()을 해주고, 음수소행성은 살아남아 있는다.
 * 양수와 음수가 같다면 둘 다 사라져야한다.
 * stack.pop()으로 기존 양수 소행성을 없애고, 음수 소행성도 사라져야하기에 alive를 false로 변경해준다.
 * 음수가 더 크면 음수 소행성만 사라지면 되기에 alive를 false로 바꾼다.
 * 반복문을 다 돌리면 stack에 남은걸 int[]에 뒤집어서 넣어주면 된다.
 */