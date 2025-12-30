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
        return new ArrayList(map.values());
    }
}

/***
 * 이 문제는 단어를 이루고 있는 원소들이 같은 것끼리 list를 만들어서 반환하라는 문제이다.
 *
 * 일단 Map을 만들어서 단어를 이루고 있는 요소들끼리 list를 만들어 줄 것이다.
 * 단어 한개씩 가지고 와서 char[]를 빼온다.
 * 이후 sort를 사용해서 정렬을 해준다.
 * 정렬한 원소를 string으로 만들어서 map의 key로 사용 할 예정이다.
 * map에 이미 key값이 있으면 str을 list에 넣어주면 된다.
 * 만약 map에 key 값이 없으면 key를 만들어주고, str을 넣으면 된다.
 * 이후 List<List<String>>을 반환해야하기 때문에 ArrayList를 새로 만들어서 그 안에 값은 map.values()를 넣어서 반환하면 된다.
 */