/*
933. Number of Recent Calls

ou have a RecentCounter class which counts the number of recent requests within a certain time frame.

Implement the RecentCounter class:

RecentCounter() Initializes the counter with zero recent requests.
int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, and returns the number of requests that has happened in the past 3000 milliseconds (including the new request). Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.


Example 1:
Input
["RecentCounter", "ping", "ping", "ping", "ping"]
[[], [1], [100], [3001], [3002]]
Output
[null, 1, 2, 3, 3]

Explanation
RecentCounter recentCounter = new RecentCounter();
recentCounter.ping(1);     // requests = [1], range is [-2999,1], return 1
recentCounter.ping(100);   // requests = [1, 100], range is [-2900,100], return 2
recentCounter.ping(3001);  // requests = [1, 100, 3001], range is [1,3001], return 3
recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
 */

class RecentCounter {
    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */

/***
 * 이 문제는 ping을 보내면 3초 이내에 몇개가 들어오는지 갯수를 확인하는 문제이다.
 *
 * 일단 두개의 함수를 작성해야하는데, RecentCounter이건 그냥 이제 시작하는 의미를 가지기 때문에 queue를 선언해주는 역할을 한다.
 * ping의 경우 t를 인자로 가지고 있는데, 이게 3초 이내에 들어오는지 확인하는 문제이다.
 * 일단 들어오는 수를 queue에 넣어준다.
 * 그리고 이 수가 t-3000보다 작으면 3초 이후에 들어오는 수이기 때문에 poll()로 빼준다.
 * 다 돌리고 나면 3000이하인 숫자만 남기때문에 size를 반환하면된다.
 */