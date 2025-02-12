/*
134. Gas Station

There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique.



Example 1:
Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3
Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.

Example 2:
Input: gas = [2,3,4], cost = [3,4,3]
Output: -1
Explanation:
You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 0. Your tank = 4 - 3 + 2 = 3
Travel to station 1. Your tank = 3 - 3 + 3 = 3
You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
Therefore, you can't travel around the circuit once no matter where you start.
 */

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int allGas = 0;
        int allCost = 0;
        int currGas = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            allGas += gas[i];
            allCost += cost[i];
        }
        if (allGas < allCost) {
            return -1;
        }
        for (int i = 0; i < gas.length; i++) {
            currGas = currGas + gas[i] - cost[i];
            if (currGas < 0) {
                currGas = 0;
                start = i + 1;
            }
        }
        return start;
    }
}

/***
 * 이 문제는 가스 충전소이다. 각각 주유소마다 얼마나 주유할 수 있는지랑, 다음 주유소까지 사용하는 비용을 input으로 준다. 그래서 어느 스테이션에서 시작해야 전부 돌고올 수 있는지를 출력하라는 것이다.
 * 결과는 시작 스테이션을 출력하던지, 없으면 -1을 출력하라는 것이였는데, -1을 나타내는 경우를 잘 생각하면 빨리 풀 수 있었다.
 *
 * 일단 -1이 되는 경우는 기름이 부족한 경우다. 그이야기는 전체적인 gas양이 전체적인 cost보다 적으면 -1이 나오는 것이다.
 * 일단 전체 기름과 전체 비용을 계산했다.
 * allGas와 allCost를 계산해서 allGas < allCost인 경우는 무조건 -1이 출력된다.
 * 이후 계산을 하면 된다.
 * currGas를 조건에 맞게 업데이트 시키면 된다. 처음 시작할땐 무조건 0이라고 두고, 내가 가는 스테이션에서 받는건 +, 다음 스테이션까지 가는 cost는 -를 한다.
 * 여기서 남은 gas가 0보다 작아지면 그 스테이션은 틀린것이다. 가망이 없기에 시작 스테이션은 아닐테고 다음 스테에션으로 넘어가야하니까 currGas를 다시 0 으로 초기화 시켜주고, start는 지금 있는 인덱스 +1 해준다. (인덱스는 0부터 시작이니까)
 */