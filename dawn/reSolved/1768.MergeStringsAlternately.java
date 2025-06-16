/*
1768. Merge Strings Alternately

ou are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.


Example 1:
Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r

Example 2:
Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b
word2:    p   q   r   s
merged: a p b q   r   s

Example 3:
Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q
merged: a p b q c   d
 */

class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < n || i < m) {
            if (i < n) {
                sb.append(word1.charAt(i));
            }
            if (i < m) {
                sb.append(word2.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }
}

/***
 * 이 문제는 단어들을 한개씩 뽑아서 새로운 문장을 만드는 문제이다.
 *
 * 일단 편의를 위해서 각 단어들의 길이를 n,m으로 저장해두었다.
 * 인덱스를 사용해서 한개씩 가지고 올 예정이기에 i를 선언해둔다.
 * String으로 만들어야하기 때문에 StringBuilder를 선언한다.
 * 이후 StringBuilder에 추가한다.
 * 인덱스별로 한개씩 가지고 와야하기때문에 while문을 통해 반복한다.
 * 두개의 단어 길이가 다를 수 있기 때문에 ||를 이용한다.
 * 인덱스가 길이를 넘어가지 않으면 한개씩 가지고 와서 StringBuilder에 넣는다.
 * 이후 StringBuilder를 String으로 변환시야하기에 toString()을 사용해서 반환한다.
 */