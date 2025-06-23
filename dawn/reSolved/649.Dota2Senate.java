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
        return !rQueue.isEmpty() ? "Radiant" : "Dire";
    }
}

/***
 * 이 문제는 한개씩 삭제해서 어떤게 남는지 확인하는 문제이다.
 *
 * R이 먼저 나오면 D를 제거할 수 있고, D가 먼저 나오면 R을 제거할 수 있다.
 * 제거 한 뒤에는 다시 맨 뒤로 돌아가서 제일 마지막에 남는게 반환되는 문제이다.
 * 일단 각각 Queue를 만들어준다.
 * senate의 길이만큼 돌리면서 나오는 인덱스를 각 queue에 넣어준다.
 * 그리고 둘다 비어있지 않을때 까지 돌려주면서 확인하면 된다.
 * 일단 나오는 순서대로 한개씩 빼준다.
 * 먼저 나온다는 것은 인덱스가 더 작다는 의미이다.
 * 만약에 r이 먼저 나오면 맨 뒤로 다시 보내면 되기 때문에 rQueue에 넣어주면 된다.
 * d가 먼저 나오면 다시 맨 뒤로 보내면 되기 때문에 dQueue에 넣어주면 된다.
 * 둘 중 먼저 끝나는게 있을것이기에 rQueue가 비어있으면 d가 살아남았다는 의미로 Dire를 반환하면 되고, 그게 아니라면 Radiant를 반환하면 된다.
 */