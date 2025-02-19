/*
30. Substring with Concatenation of All Words

You are given a string s and an array of strings words. All the strings of words are of the same length.
A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.
For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.


Example 1:
Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation:
The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.

Example 2:
Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []
Explanation:
There is no concatenated substring.

Example 3:
Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]
Explanation:
The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].
 */

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList();
        int wordLen = words[0].length();
        int stringLen = s.length();

        Map<String, Integer> map = new HashMap();
        for (String character : words) {
            map.put(character, map.getOrDefault(character, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            int left = i, j = i, c = 0;
            Map<String, Integer> map2 = new HashMap();
            while (j + wordLen <= stringLen) {
                String word1 = s.substring(j, j + wordLen);
                j += wordLen;
                if (map.containsKey(word1)) {
                    map2.put(word1, map2.getOrDefault(word1, 0) + 1);
                    c++;

                    while (map2.get(word1) > map.get(word1)) {
                        String word2 = s.substring(left, left + wordLen);
                        map2.put(word2, map2.get(word2) - 1);
                        left += wordLen;
                        c--;
                    }
                    if (c == words.length) {
                        result.add(left);
                    }
                } else {
                    map2.clear();
                    c = 0;
                    left = j;
                }
            }
        }
        return result;
    }
}

/***
 * 이 문제는 s와 words를 주고, s안에 words가 다 조합된 애들이 들어간 substirng의 첫번째 인덱스의 list를 가지고 오라는 것이다.
 * 조합되는건 순서와 상관 없다.
 *
 * 일단 답을 내놓을 List<Integer> result를 한개 선언한다.
 * 그리고 단어의 길이는 항상 같다. wordLen을 선언하고, 입력으로 들어온 s의 길이도 선언한다.
 * 그리고 map으로 무슨 단어가 들어왔는지 저장할것이다.
 * for문을 사용해서 key는 단어가 되고, value는 횟수를 지정한다.
 * 그리고 wordLen만큼 다 있는지 확인하는 작업이 필요하다.
 * 일단 left라는 처음부터 시작하는 인덱스를 한 개 선언하고, j는 wordLen만큼 커져서 인덱스를 탐색하는 아이이다. c는 word개수만큼 다 들어왔는지 확인하는 변수다.
 * 그리거 map한개를 더 선언한다. 무슨 단어가 들어왔는지 확인하기 위해서이다.
 * 그리거 j+wordLen이 s의 길이보다 작을때만 당연히 작동해야한다.
 * 단어를 받아놓고, j는 wordLen을 더해준다.
 * 그리고 그 단어가 처음 선언한 map에 있는지 확인하고, 있으면 map2에 넣어준다. 그리고 단어 한개를 받은것이기 때문에 c++를 한다.
 * 주의해하하는 부분은 다음부분이다. map1에 있다고 해서 계속 받아오는게 아니다. 한 번 만 들어와야하는그거보다 더 많이 들어어면 원상복구를 시켜야하기에 map2에 +1한걸 다시 -1로 돌려놓고, c++한거 다시 c--로 돌려놓고, 그 단어를 지나치고 다시 봐야하기 때문에 left에 wordLen을 더한다.
 * 그리고 단어를 다 입력받았다면 그건 정답이기때문에 result에 left를 더해준다.
 * 근데 생뚱맞은 단어가 들어온다면 그건 map2를 clear시키고, c는 다시 0으로 left는 j로 업데이트 해준다.
 */