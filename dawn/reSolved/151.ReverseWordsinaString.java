/*
151. Reverse Words in a String

Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.


Example 1:
Input: s = "the sky is blue"
Output: "blue is sky the"

Example 2:
Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:
Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */

class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for (int i = words.length - 1; i > 0; i--) {
            sb.append(words[i]);
            if (words[i - 1].length() > 0) {
                sb.append(" ");
            }
        }
        sb.append(words[0]);
        return sb.toString();
    }
}

/***
 * 이 문제는 문장에 있는 단어의 순서를 뒤집어서 새로운 문장을 만드는 문제이다.
 *
 * 새로운 문장을 만들어야하기 때문에 StringBuilder를 선언한다.
 * 그리고 공백을 기준으로 문장에 있는 단어들을 나눠서 list에 넣어둔다.
 * 뒤에서부터 넣어야하기때문에 for문을 돌릴때 큰 수부터 돌린다.
 * sb에 넣은 후에, 만약에 다음 단어가 공백이 아니라면 띄어쓰기를 넣기위해 " "을 추가해준다.
 * 그리고 마지막 단어 뒤에는 공백이 없어야하기때문에 for문 밖에서 words[0]을 추가해준다.
 * 이후 string으로 반환하기 위해서 toString()으로 바꿔서 반환한다.
 */