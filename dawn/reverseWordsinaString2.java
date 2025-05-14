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
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i =words.length-1; i>0; i--){
            sb.append(words[i]);
            if(words[i-1].length()>=1){
                sb.append(" ");
            }
        }
        sb.append(words[0]);
        return sb.toString();
    }
}

/***
 * 이 문제는 저번에 풀었던 문제이다.
 * 단어 배열이 문장으로 있을때, 맨 뒤 단어부터 다시 배열하여 새로운 문장을 만드는데, 공백은 두개 이상이 있으면 안된다.
 *
 * 일단 공백 단위로 잘라서 words 배열을 만들어준다.
 * 그리고 stringBuilder를 한개 선언해준다.
 * 그리고 반복문을 통해 맨 뒤 단어부터 StringBuilder에 붙여줄거다.
 * 여기서 주의해야할 점이 공백을 추가해주는건데, 다음에 붙일 단어가 공백이 아니라면 공백을 추가해주는 것이다.
 * 그게 words[i-1].length()이고, 이게 1보다 크거나 같다는건 공백이 아니라는 것이다.
 * 그런 경우엔 공백을 추가로 붙여준다.
 * 그리고 맨 마지막 단어를 추가해주어야 맨 마지막에 공백이 붙지 않는다.
 * 그 이후 stringBuilder를 toString()으로 변환해서 return하면 된다.
 */