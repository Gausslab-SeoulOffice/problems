/*
763. Partition Labels

You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part. For example, the string "ababcc" can be partitioned into ["abab", "cc"], but partitions such as ["aba", "bcc"] or ["ab", "ab", "cc"] are invalid.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.


Example 1:
Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

Example 2:
Input: s = "eccbbbbdec"
Output: [10]
 */

class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        List<Integer> result = new ArrayList<>();

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);

            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}

/***
 * 이 문제는 어떤 문자가 나왔을때 나오는 최대의 길이를 나타내는걸 구하는 문제이다.
 *
 * 일단 각각 단어들을 최대로 나오는 인덱스를 저장한다.
 * 그리고 start와 end를 이용해서 위치를 계산할 예정이다.
 * 순서대로 시작하면서 end를 업데이트 하면 된다.
 * i와 end가 동일하게 끝까지 갔다면 result에 위치를 추가해준다.
 * 그리고 Start를 업데이트 해서 다시 for문을 돌려준다.
 * 이후 result를 반환하면 된다.
 */