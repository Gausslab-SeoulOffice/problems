/*
242. Valid Anagram

Given two strings s and t, return true if t is an anagram of s, and false otherwise.


Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

 */

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }
        return true;
    }
}

/***
 * 이 문제는 에너그램 문제이다.
 * s와 t에 들어간 글자의 갯수가 동일한지 묻는 문제이다.
 *
 * 일단 s와 t의 길이가 다르면 무조건 false이다.
 * 그리고 map을 선언해서 s를 돌면서 캐릭터의 갯수를 세서 넣어준다.
 * 그리고 t를 돌면서 map 안에 글자가 없거나 그 갯수가 0보다 작으면 false를 반환하고, 있으면 갯수에서 -1을 한걸로 업데이트를 한다.
 * 끝까지 돌았을때 걸리지 않고 다 돌면 true이다.
 */