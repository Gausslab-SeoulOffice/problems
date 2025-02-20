/*
3. Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring without duplicate characters.


Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(i));
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }
}

/***
 * 이 문제는 이제 중복되지 않은 단어가 나오는 가장 긴 길이를 return하라는 것이다.
 *
 * 일단 길이를 업데이트 해야해서 선언했다. 그리고 중복을 이제 볼 수 있는 set한개를 선언한다
 * 처음부터 끝까지 확인할건데, 한 문자씩 확인하면서 set에 있으면 이제 삭제하고, 맨 왼쪽꺼랑 겹친거니까 left++를 해준다. 그리고 set에 추가하고 길이를 비교해서 업데이트 해준다.
 * 다르면 set에 없으니까 그낭 추가만 해주고, 길이만 업데이트 해준다.
 */