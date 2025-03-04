/*
49. Group Anagrams

Given an array of strings strs, group the anagrams together. You can return the answer in any order.


Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Explanation:
There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String sortedString = new String(ch);

            if (map.containsKey(sortedString)) {
                map.get(sortedString).add(str);
            } else {
                map.put(sortedString, new ArrayList<>());
                map.get(sortedString).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }
}

/***
 * 이 문제는 같은 에너그램끼리 리스트로 나오라는 문제이다.
 *
 * 일단 map 선언해두고, key는 sort한 단어를 넣고, 그 뒤에 원래 단어를 추가해준다.
 * 그리고 그대로 map을 출력해주면 딱 맞다
 */