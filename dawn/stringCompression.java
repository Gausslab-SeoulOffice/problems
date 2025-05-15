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
 * 이 문제는 단어들이 반복해서 나오는것을 압축해서 문자열로 변환하고, 그 문자열의 길이를 반환하는 문제이다.
 *
 * 일단 반복해서 나오는 단어들을 숫자를 세기 위해 while문으로 검색해서 count를 올려준다.
 * count가 1이면 그냥 문자만 그대로 두면 되기에 chars[answer++]=ch만하면 된다.
 * 그리고 count가 그 이상이면 문자를 그대로 두고, 숫자를 char로 변환해준다.
 * 변환해준걸 char[answer++] 에 넣어주면 된다.
 * while문 안에서 이미 i를 증가시켰기 떄문에,
 * i++가 한 번 더 진행돼서 다음 문자를 가리키고 있음.
 * 하지만 **for 루프의 i++**도 있기 때문에, 다음 루프로 넘어갈 때 1칸 더 건너뛰게 된다.
 * ➡ 그래서 i-- 해줘야 다음 루프에서 현재 위치에서 다시 시작되도록 조정
 */