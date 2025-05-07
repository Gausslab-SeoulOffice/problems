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
        for (int i : candies) {
            max = Math.max(max, i);
        }
        for (int i = 0; i < candies.length; i++) {
            if (extraCandies + candies[i] >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}

/***
이 문제는 현재 가지고 있는 candy의 숫자와 extraCandies의 숫자를 더했을때 가지고 있는 가장 큰 수인지 true, false를 list에 담아 반환하는 문제이다.

일단 정답을 담을 result를 선언한다.
가장 큰 수를 찾기위해 for문을 돌리는데 이때 가장 큰 수를 Math.max를 이용해서 찾아서 max에 넣는다.
그리고 반복문으로 현재 가지고 있는 candy와 extracandy를 합친 수가 max보다 크면 true, 작으면 false를 result에 넣는다. 
반복문을 다 돌리면 result를 반환한다.
***/
