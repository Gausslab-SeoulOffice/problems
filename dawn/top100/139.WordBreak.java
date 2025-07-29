/*
139. Word Break

Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.


Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 */

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return dfs(s, set, new HashMap<>());
    }

    private boolean dfs(String s, Set<String> set, Map<String, Boolean> map) {
        if (s.isEmpty()) {
            return true;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (String word : set) {
            if (s.startsWith(word)) {
                String substring = s.substring(word.length());
                if (dfs(substring, set, map)) {
                    map.put(substring, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
}

/***
 * 이 문제는 s가 wordDict으로 이뤄진 단어로 쪼개질 수 있는지 묻는 문제이다.
 *
 * 일단 wordDict을 set으로 해둔다.
 * 그리고 dfs함수를 사용해서 쪼갤 수 있을때까지 쪼갠다.
 * s가 비어 있으면 true이고, map에 있으면 true이다.
 * 그게 아니면 쪼개야하는데 startsWith으로 일단 단어를 쪼개서 남은 단어를 다시 dfs로 보낸다.
 * 다 쪼개지면 ""이거라 true이고, 그 다음 단어들을 map에 넣어둔다.
 * 다 했는데 안된거라면 false를 반환하면 된다.
 */