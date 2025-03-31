/*
66. Plus One

You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.


Example 1:
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].

Example 2:
Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].

Example 3:
Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
 */

class Solution {
    public int[] plusOne(int[] digits) {
        int lastIndex = digits.length-1;
        digits[lastIndex] += 1;
        if(digits[lastIndex]==10){
            int digit = 0;
            for(int i=lastIndex; i>=0; i--){
                if(i == 0 && digits[i] == 10){
                    int[] answerArr = new int[digits.length+1];
                    for(int j=1; j< digits.length; j++){
                        answerArr[j] = digits[j];
                    }
                    answerArr[0] = 1;
                    answerArr[1] = 0;
                    return answerArr;

                }
                if(digits[i] == 10){
                    digits[i] = 0;
                    digits[i-1] += 1;
                }else{
                    break;
                }
            }
            return digits;
        }
        return digits;
    }
}

/***
 * 이 문제는 배열을 주면 그 마지막 숫자에 1을 더해서 배열을 다시 반환하는 것이다.
 *
 * 일단 마지막 인덱스를 가지고 오고, 마지막 숫자를 가지고 와서 1을 더해준다.
 * 그 마지막 숫자가 10이라면 이제 확인을 해야한다. 그러면 그 자리수를 0으로 만들고, 그 앞에 있는 i-1에 1을 더해준다.
 * 그리고 또 확인할게 제일 앞까지 갔을때를 확인해야한다. 그렇게 되면 맨 앞에 1 그 뒤에 0을 넣어서 숫자를 완성시킨다.
 */