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

        for (char ch : word1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        for (char ch : word2.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        if (!map1.keySet().equals(map2.keySet())) {
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
 * 이 문제는 단어를 변경해서 word2단어를 만들수 있는지 확인하는 문제이다. 붙어있으면 통으로 변경할 수 있다는 의미이다.
 *
 * 엄청 좋은 방법은 아닌것 같다.
 * 일단 두 단어의 길이가 다르면 false를 반환한다.
 * 각각의 map을 만들어서 단어와 나온 횟수를 입력한다.
 * 그리고 각 map의 keySet을 확인한다.
 * 나온 단어가 다르면 그건 변경을 해도 false가 나올 수 밖에 없다.
 * 그리고 각각 list를 만들어서 나온 횟수를 비교할것이다.
 * 나온 횟수가 같으면 이제 어떤 조합으로도 만들 수 있다는 것을 의미하기 때문이다.
 * list를 만들때는 각 map의 values()를 이용해서 만들어준다.
 * 만들고 나면 sort를 시켜서 각각의 리스트가 동일해야한다.
 */