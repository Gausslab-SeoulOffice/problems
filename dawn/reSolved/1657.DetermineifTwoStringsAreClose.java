/*
1657. Determine if Two Strings Are Close

Two strings are considered close if you can attain one from the other using the following operations:

Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.


Example 1:
Input: word1 = "abc", word2 = "bca"
Output: true
Explanation: You can attain word2 from word1 in 2 operations.
Apply Operation 1: "abc" -> "acb"
Apply Operation 1: "acb" -> "bca"

Example 2:
Input: word1 = "a", word2 = "aa"
Output: false
Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.

Example 3:
Input: word1 = "cabbba", word2 = "abbccc"
Output: true
Explanation: You can attain word2 from word1 in 3 operations.
Apply Operation 1: "cabbba" -> "caabbb"
Apply Operation 2: "caabbb" -> "baaccc"
Apply Operation 2: "baaccc" -> "abbccc"
 */

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(char ch : word1.toCharArray()){
            map1.put(ch, map1.getOrDefault(ch, 0)+1);
        }
        for(char ch : word2.toCharArray()){
            map2.put(ch, map2.getOrDefault(ch, 0)+1);
        }

        if(!map1.keySet().equals(map2.keySet())){
            return false;
        }

        List<Integer> list1 = new ArrayList<>(map1.values());
        List<Integer> list2 = new ArrayList<>(map2.values());

        Collections.sort(list1);
        Collections.sort(list2);

        return list1.equals(list2);
    }
}

/***
 * 이 문제는 단어 두 개가 주어졌을때 변경가능한지 묻는문제이다.
 * 추가나 삭제는 안되고, 같은 갯수라면 변경 가능하다.
 *
 * 일단 각 map에 단어와 나온 횟수즐 저장해준다.
 * 그리고 나온 단어들의 집합은 같아야한다.
 * 나온 횟수를 각각 list로 만들어주고, sort를 시킨다.
 * 그 횟수들이 같으면 true, 아니면 false를 반환한다.
 */