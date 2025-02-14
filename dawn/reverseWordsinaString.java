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
            if (words[i - 1].length() >= 1) {
                sb.append(" ");
            }
        }
        sb.append(words[0]);
        return sb.toString();
    }
}

/***
 * 이 문제는 문장을 줄테니 공백을 기준으로 단어를 분리해서 뒤에서부터 재배열해서 문장 가지고 오라는것이다.
 * 살짝 애먹은 부분은 공백이 여러개 붙어있을 수 있다는 부분이었다.
 *
 * 일단 string을 return해야하니까 stringBuilder를 선언해주고, 공백단위로 끊기 위해 split을 해준다.
 * 맨 뒤에서부터 읽어와야하니까 for문은 뒤에서부터 읽도록 해주고,일단 맨 뒤에 있는 단어부터 써주고 이제 앞에가 공백이 아니면 공백을 넣어준다.
 */