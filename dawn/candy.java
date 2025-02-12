/*
135. Candy

There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.



Example 1:
Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

Example 2:
Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
 */

class Solution {
    public int candy(int[] ratings) {
        int[] eachCandy = new int[ratings.length];
        int answer = 0;
        for (int i = 0; i < ratings.length; i++) {
            eachCandy[i] = 1;
        }
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                eachCandy[i] = eachCandy[i-1]+1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                eachCandy[i] = Math.max(eachCandy[i], eachCandy[i+1]+1);
            }
        }
        for (int i = 0; i < ratings.length; i++) {
            System.out.println(eachCandy[i]);
            answer += eachCandy[i];
        }
        return answer;
    }
}

/***
 * 이 문제는 Hard치고 쉽다고 생각했는데 효율은 똥망으로 풀긴했다.
 * 일단 우선순위? 이런게 있는데 이게 높으면 옆에 있는 애보다 사탕을 많이 줘야한다. 무조건 1개 이상은 줘야하고, 그때 줄수 있는 최소의 사탕수를 구하는 것이다.
 * 예시로 [1, 0, 2]이렇게 나오는데, 그러면 일단 1개씩 다주고 [1, 1, 1] 그 다음에 1이 0보다 크기때문에 1개 더 줘서 [2, 1 1]이 되고, 0보다 2가 크기때문에 [2, 1, 2]개가 되어서 총 5가 된다. 이건 이해가 쉬웠다.
 * 두번째 예시로 [1, 2, 2]가 나오는데 일단 1개씩 다주고 [1, 1, 1] 그 다음에 두번째에 있는 얘가 1보다 2가 크기때문에 [1, 2, 1]이렇게 나오고, 마지막에 얘도 우선순위가 2이긴한데 옆에 있는 2랑 우선순위가 같지, 높지는 않기 때문에 더 주지 않아도 된다. 고로 [1, 2, 1] 총 4개가 나오게 된다.
 *
 * 일단 각각 사탕 수를 세기 위해 int[]배열을 만들어준다. 그리고 갯수를 합칠 answer이라는 아이도 선언해준다. 이후에 일단 사탕을 각각 1개씩은 줘야하니까. eachCandy에 1로 다 초기화 시켜준다.
 * 이후에 비교를 하면 된다. 먼저 내 왼쪽보다 크면 왼쪽에 준 사탕 개수보다 +1을 해서준다. 이후에 오른쪽에서 비교해서 오면 된다.
 * 오른쪽에서 올때는 인덱스를 이용하기때문에 ratings.length-2부터 시작하게된다. 내 오른쪽에 있는 얘보다 우선순위가 높으면 선택하면된다.
 * 지금 개수와 오른쪽애한테 준 사탕 개수+1 한 것 중에 더 높은걸 선택해서 사탕을 주면 된다. 이걸 하다면 eachCandy에 사탕의 개수가 쌓일것이고, 이걸 answer이라는 변수에 합쳐주고 return시키면 완성이다.
 */