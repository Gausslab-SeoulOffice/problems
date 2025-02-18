/*
167. Two Sum II - Input Array Is Sorted

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
The tests are generated such that there is exactly one solution. You may not use the same element twice.
Your solution must use only constant extra space.


Example 1:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

Example 2:
Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

Example 3:
Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
 */

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int leftIndex = 0;
        int rightIndex = numbers.length - 1;
        while (leftIndex < rightIndex) {
            if (numbers[leftIndex] + numbers[rightIndex] == target) {
                return new int[] { leftIndex + 1, rightIndex + 1 };
            } else if (numbers[leftIndex] + numbers[rightIndex] > target) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }
        return new int[] { -1, -1 };
    }
}

/***
 * 이 문제는 두 숫자를 찾아서 더했을때 target이 되는지 찾고, 그 인데스에서 +1을 해서 그 인자 2개를 찾는 문제이다.
 * 좋은건 이미 sort가 되어 있다는 점이다.
 *
 * 그렇게 되면 제일 왼쪽에 있는데 가장 작은 수, 가장 오른쪽에 있는데 가장 큰 수가 된다는 의미이다.
 * 각각 두 수를 맨 끝수로 하고, target보다 크면 오른쪽에 있는 인자를 한개 작은 수인 왼쪽으로 한 칸 옮기면 될거같고, target보다 작으면 왼쪽에 있는 인자를 한 개 큰 수인 오른쪽으로 한 칸 옮기면 되겠다.
 * 그 후에 나온 index 값에 각각 +1을 해서 return 하면 된다.
 */