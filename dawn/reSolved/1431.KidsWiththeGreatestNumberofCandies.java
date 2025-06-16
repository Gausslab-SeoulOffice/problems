/*
1431. Kids With the Greatest Number of Candies

There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.

Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.

Note that multiple kids can have the greatest number of candies.


Example 1:
Input: candies = [2,3,5,1,3], extraCandies = 3
Output: [true,true,true,false,true]
Explanation: If you give all extraCandies to:
- Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
- Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
- Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
- Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
- Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.

Example 2:
Input: candies = [4,2,1,1,2], extraCandies = 1
Output: [true,false,false,false,false]
Explanation: There is only 1 extra candy.
Kid 1 will always have the greatest number of candies, even if a different kid is given the extra candy.

Example 3:
Input: candies = [12,1,12], extraCandies = 10
Output: [true,false,true]
 */

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}

/***
 * 이 문제는 extraCandies를 더했을때 원래 가지고 있던 캔디들의 가장 큰 수 보다 크거나 같으면 true, 그게 아니라면 false를 반환하라는 문제이다.
 *
 * 일단 max를 찾아야하기 때문에 처음에는 가장 작은 수로 선언해둔다.
 * 그리고 for문을 통해 가장 큰 수를 찾아둔다.
 * 그리고 for문을 돌리면서 extraCandies와 가지고 있던 사탕의 갯수를 더해서 max보다 크거나 같은지 확인한다.
 * 크거나 같으면 true, 그게 아니라면 false를 List에 추가해준다.
 * 다 돌리면 List에 값들이 다 들어가 있게되기에, result를 반환한다.
 */