/*
205. Isomorphic Strings

Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.


Example 1:
Input: s = "egg", t = "add"
Output: true
Explanation:
The strings s and t can be made identical by:
Mapping 'e' to 'a'.
Mapping 'g' to 'd'.

Example 2:
Input: s = "foo", t = "bar"
Output: false
Explanation:
The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

Example 3:
Input: s = "paper", t = "title"
Output: true
 */

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!mapS.containsKey(s.charAt(i))) {
                mapS.put(s.charAt(i), i);
            }
            if (!mapT.containsKey(t.charAt(i))) {
                mapT.put(t.charAt(i), i);
            }
            if (!mapS.get(s.charAt(i)).equals(mapT.get(t.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}

/***
 * 이 문제는 두 문장이 같은 형태인지를 묻는 문제이다.
 * egg, add가 있으면 e는 a랑 짝을 이뤄서 나오고 g는 d랑 짝을 이뤄서 나오기때문에 true가 되는 형식이다.
 *
 * 그래서 hashMap을 사용하게 된다. 두 개의 HashMap을 선언하고, for문을 돌린다.
 * 한 단어씩 s,t를 확인 할 것이다.
 * 일단 단어가 있는지 확인하고, 없으면 <단어,인데스> 형태로 넣는다. 그리고 확인을 한다.
 * 중간에 둘 다 나온 인덱스가 동일하지 않으면, false, 끝까지 갔는데 다 동일하면 true를 반환한다.
 */