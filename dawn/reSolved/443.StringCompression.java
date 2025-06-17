/*
443. String Compression

Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space.


Example 1:
Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".

Example 2:
Input: chars = ["a"]
Output: Return 1, and the first character of the input array should be: ["a"]
Explanation: The only group is "a", which remains uncompressed since it's a single character.

Example 3:
Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
 */

class Solution {
    public int compress(char[] chars) {
        int answer = 0;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == ch) {
                count++;
                i++;
            }
            if (count == 1) {
                chars[answer++] = ch;
            } else {
                chars[answer++] = ch;
                for (char digit : Integer.toString(count).toCharArray()) {
                    chars[answer++] = digit;
                }
            }
            i--;
        }
        return answer;
    }
}

/***
 * 이 문제는 연속으로 나오는 알파벳을 압축해서 그 길이가 얼마인지 구하는 문제이다.
 *
 * 일단 길이를 구할 answer이라는 변수를 선언한다.
 * 그리고 연속으로 나오는 값을 압축해야하기때문에 for문을 돌리면서 확인한다.
 * 알파벳을 순서대로 정해놓고, 그 값이 연속해서 나올 때까지 count를 올려준다.
 * 만약에 1번만 나온다면 1은 저장할 필요가 없고, 그냥 알파벳만 저장하면 되기때문에 chars에 ch만 저장해둔다.
 * 그게 아니라면 숫자도 같이 저장해주어야한다.
 * count가 10이상부터는 두자리를 차지하는것이기 때문에 int를 char로 변경해서 넣어주어야한다.
 * 그리고 마지막에 i++이 되어이씩 떄문에, for문을 다시 돌기전에 i--를 해주어야한다.
 * 다 돌리면 answer의 길이가 자동으로 압축문장의 길이가 되어있기 때문에 answer를 반환하면 된다.
 */