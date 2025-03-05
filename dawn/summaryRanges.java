/*
228. Summary Ranges

You are given a sorted unique integer array nums.
A range [a,b] is the set of all integers from a to b (inclusive).
Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b


Example 1:
Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"

Example 2:
Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"

 */

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if (nums.length == 0) {
            return result;
        }

        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    result.add(Integer.toString(start));
                } else {
                    result.add(start + "->" + nums[i - 1]);
                }
                start = nums[i];
            }
        }
        if (start == nums[nums.length - 1]) {
            result.add(Integer.toString(start));
        } else {
            result.add(start + "->" + nums[nums.length - 1]);
        }
        return result;
    }
}

/***
 * 이 문제는 배열이 들어오고 연속적인 숫자가 아니면 list에 그 숫자가 들어오고 연속적이면 처음 -> 끝 이런 순으로 리스트에 들어오고 그 리스트를 반환하는 문제이다.
 *
 * 일단 return을 위한 리스트 한개를 선언해준다.
 * 그리고 예외처리고 배열에 숫자가 한개도 없으면 그대로 리턴하는걸 적는다.
 * 그리고 처음 숫자를 저장해놓기 위해 start라는 변수를 선언한다.
 * 인덱스1부터 확인할건데, 지금 숫자가 연속되지 않때, 그게 start와 같으면 걍 그 숫자 한개라는거니까 그걸 result에 담고, 한 개가 아니라면 연속되는 숫자가 있었다는거니까 start -> nums[i-1]까지 string으로 add한다.
 * 그리고 이제 마지막까지 왔다면 맨 뒤에 있는 것도 result에 넣고, 마지막으로 result를 반환한다.
 */