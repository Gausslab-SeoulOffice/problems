/*
76. Minimum Window Substring

Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
The testcases will be generated such that the answer is unique.


Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.

 */

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> charCount = new HashMap();
        for (char ch : t.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        int targetCharRemaining = t.length();
        int[] min = { 0, s.length() + 1 };
        int startIndex = 0;

        for (int endIndex = 0; endIndex < s.length(); endIndex++) {
            char ch = s.charAt(endIndex);
            if (charCount.containsKey(ch) && charCount.get(ch) > 0) {
                targetCharRemaining--;
            }
            charCount.put(ch, charCount.getOrDefault(ch, 0) - 1);

            if (targetCharRemaining == 0) {
                while (true) {
                    char charAtStart = s.charAt(startIndex);
                    if (charCount.containsKey(charAtStart) && charCount.get(charAtStart) == 0) {
                        break;
                    }
                    charCount.put(charAtStart, charCount.getOrDefault(charAtStart, 0) + 1);
                    startIndex++;
                }

                if (endIndex - startIndex < min[1] - min[0]) {
                    min[0] = startIndex;
                    min[1] = endIndex;
                }

                charCount.put(s.charAt(startIndex), charCount.getOrDefault(s.charAt(startIndex), 0) + 1);
                targetCharRemaining++;
                startIndex++;
            }
        }
        return min[1] >= s.length() ? "" : s.substring(min[0], min[1] + 1);
    }
}

/***
 * 이 문제는 t가 포함된 가장 짧은 substring을 찾는 것이다.
 *
 * 일단 예외처리부터 하면 s가 t보다 짧으면 그냥 ""이다.
 * 그리고 찾으려고 하는 t를 한단어씩 쪼개서 map에 넣어준다. 단어:횟수 형태가 된다.
 * 그리고 찾으려는 t의 길이를 저장해 놓고, 짧은 substring의 인덱스를 선언해준다.
 * 그리고 한단어씩 찾는것이다. 일단 입력받은 s의 첫단어부터 확인한다. 그리고 그게 map에 있고, 횟수가 0이상이면 찾으려는 길이--를 해준고, map에서 횟수를 한 번 차감한다.
 * 이걸 s의 마지막 인덱스까지 전부 들어야한다.
 * 근데 이 와중에 찾으려는 t를 다 돌아서 targetCharRemaining이 0이 되었다면, 처음 단어부터 확인할것이다.
 * s의 첫 단어가 map에 들어가 있고, 그 횟수가 0이 된거면 멈추고, 아니라면 map에 넣어준다. 그리고 startIndex++를 한다.
 * 그리고 이걸 다 돌린 이후에, 더 짧은 substring이 나오면 업데이트 해준다.
 * 그리고 map에다가 startIndex에 있는 단어를 넣고, 횟수를 중가시킨다.
 * targerCharRemaining++과 startIndex++를 한다.
 *
 * 사실 잘 이해 못하겠다.
 */