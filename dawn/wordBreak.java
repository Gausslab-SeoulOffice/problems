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
        Set<String> wordSet = new HashSet<>(wordDict);
        return dfs(s, wordSet, new HashMap<>());
    }

    private boolean dfs(String s, Set<String> wordSet, Map<String, Boolean> map){
        if(s.isEmpty()){
            return true;
        }
        if(map.containsKey(s)){
            return map.get(s);
        }
        for(String word: wordSet){
            if(s.startsWith(word)){
                String rest = s.substring(word.length());
                if(dfs(rest, wordSet, map)){
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
}

/***
 * 이 문제는 wordDict에 있는 단어로 s를 나눠서 만들 수 있냐고 묻는 문제이다.
 *
 * 일단 word를 한개씩 가져와서 확인하는 것이다.
 * wordDict를 HashSet으로 만들어서 단어 포함 여부를 빠르게 체크
 * dfs()로 문자열을 앞에서부터 단어 단위로 잘라가며 확인
 * s: 지금 남은 문자열
 * wordSet: 단어 사전
 * map: 중복 탐색 방지용 메모이제이션 (캐시)
 * s가 word로 시작하면 남은 문자열을 다시 dfs로 확인하면 된다.
 */