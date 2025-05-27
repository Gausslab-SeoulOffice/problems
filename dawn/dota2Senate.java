/*
649. Dota2 Senate

In the world of Dota2, there are two parties: the Radiant and the Dire.

The Dota2 senate consists of senators coming from two parties. Now the Senate wants to decide on a change in the Dota2 game. The voting for this change is a round-based procedure. In each round, each senator can exercise one of the two rights:

Ban one senator's right: A senator can make another senator lose all his rights in this and all the following rounds.
Announce the victory: If this senator found the senators who still have rights to vote are all from the same party, he can announce the victory and decide on the change in the game.
Given a string senate representing each senator's party belonging. The character 'R' and 'D' represent the Radiant party and the Dire party. Then if there are n senators, the size of the given string will be n.

The round-based procedure starts from the first senator to the last senator in the given order. This procedure will last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.

Suppose every senator is smart enough and will play the best strategy for his own party. Predict which party will finally announce the victory and change the Dota2 game. The output should be "Radiant" or "Dire".



Example 1:
Input: senate = "RD"
Output: "Radiant"
Explanation:
The first senator comes from Radiant and he can just ban the next senator's right in round 1.
And the second senator can't exercise any rights anymore since his right has been banned.
And in round 2, the first senator can just announce the victory since he is the only guy in the senate who can vote.

Example 2:
Input: senate = "RDD"
Output: "Dire"
Explanation:
The first senator comes from Radiant and he can just ban the next senator's right in round 1.
And the second senator can't exercise any rights anymore since his right has been banned.
And the third senator comes from Dire and he can ban the first senator's right in round 1.
And in round 2, the third senator can just announce the victory since he is the only guy in the senate who can vote.
 */

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();

        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                rQueue.offer(i);
            } else {
                dQueue.offer(i);
            }
        }

        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            int r = rQueue.poll();
            int d = dQueue.poll();

            if (r < d) {
                rQueue.offer(r + senate.length());
            } else {
                dQueue.offer(d + senate.length());
            }
        }
        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }
}

/***
 * 이 문제는 정당이 2개가 있는데 R, D 정당이 있고 R이 들어오면 뒤에 들어오는 D 정당을 죽이고 그 다음으로 다시 들어올 수있는것이다. 이제 둘 중 한 정당만 남게 되면 그 정당이 무엇인지 출력하라는 문제이다.
 *
 * 일단 각 정당들이 언제 나오는지 확인하기 위해 Queue를 두개 만들어놓는다.
 * 이후 각 Queue에 언제 나오는지 그 인덱스를 넣어준다.
 * 그리고 둘 중 한개만 남으면 성공이기 때문에 둘 다 비어 있지 않을때까지 계속한다.
 * 먼저 앞에 있는걸 한개씩 가져와서 인덱스를 비교한다.
 * 인덱스가 작은게 이긴 것이기 때문에 r<d이라면 r이 이긴것이다.
 * 다시 rQueue에 인덱스를 넣을건데, 맨 뒤에 넣어야하기때문에 지금 들고 있는 인덱스 값+크기값 으로 넣어준다.
 * 이렇게 하다보면 두 queue중에 한 개가 비어 있을 수 있다.
 * 그런 경우 rQueue를 확인해서 이 큐가 비어 있으면 dire를 반환하고, 그게 아니라면 r이 남은 것이기 때문에 radiant를 반환해준다.
 */