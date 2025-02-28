/*
290. Word Pattern

Given a pattern and a string s, find if s follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:

Each letter in pattern maps to exactly one unique word in s.
Each unique word in s maps to exactly one letter in pattern.
No two letters map to the same word, and no two words map to the same letter.


Example 1:
Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Explanation:
The bijection can be established as:
'a' maps to "dog".
'b' maps to "cat".

Example 2:
Input: pattern = "abba", s = "dog cat cat fish"
Output: false

Example 3:
Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
 */

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        HashMap<Character, String> charMap = new HashMap<>();
        HashMap<String, Character> wordMap = new HashMap<>();

        if(pattern.length() != words.length){
            return false;
        }

        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (!charMap.containsKey(c)) {
                charMap.put(c, word);
            }
            if (!wordMap.containsKey(word)) {
                wordMap.put(word, c);
            }
            if (!charMap.get(c).equals(word) || !wordMap.get(word).equals(c)) {
                return false;
            }
        }
        return true;
    }
}

/***
 * 이 문제는 단어랑 캐릭터가 동일한게 나오는지 확인하는 문제이다.
 * abba -> dog cat cat dog 이렇게 되면 맞는것이다.
 *
 * 일단 string을 공백단위로 나눠야 해서 String[] words를 선언해주었다.
 * 그리고 각각 HashMap을 선언한다.
 * 한개의 for문에 확인하면서 돌릴 것이다.
 * 캐릭터 한 개와 단어 한 개를 가지고 온다.
 * 그리고 각각의 map에 없으면 추가해준다.
 * 그리고 확인한다. 같은 자리에 같은 단어인지, 같은 자리에 같은 캐릭터 인지. 다르다면 false, 끝까지 같다면 true이다.
 *
 * 여기서 틀린적이 있다.
 * 이유는 예외처리를 안해서이다.
 * 윗 줄에 나오는 pattern와 words의 길이가 다르면 무조건 false를 반환해야한다.
 */