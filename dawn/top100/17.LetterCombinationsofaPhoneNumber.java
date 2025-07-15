/*
17. Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
Input: digits = ""
Output: []

Example 3:
Input: digits = "2"
Output: ["a","b","c"]
 */

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Map<Integer, List<Character>> map = new HashMap<>();
        map.put(2, Arrays.asList('a', 'b', 'c'));
        map.put(3, Arrays.asList('d', 'e', 'f'));
        map.put(4, Arrays.asList('g', 'h', 'i'));
        map.put(5, Arrays.asList('j', 'k', 'l'));
        map.put(6, Arrays.asList('m', 'n', 'o'));
        map.put(7, Arrays.asList('p', 'q', 'r', 's'));
        map.put(8, Arrays.asList('t', 'u', 'v'));
        map.put(9, Arrays.asList('w', 'x', 'y', 'z'));

        if (digits.length() == 0) {
            return result;
        }
        compute(result, sb, map, digits, 0);
        return result;
    }

    private void compute(List<String> result, StringBuilder sb, Map<Integer, List<Character>> map, String digits,
                         int index) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        List<Character> letters = map.get(digit);
        for (char letter : letters) {
            sb.append(letter);
            compute(result, sb, map, digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

/***
 * 이 문제는 백트래킹으로 문자들의 조합을 게산하는 문제이다.
 *
 * 일단 map에 모든 문자들을 넣어둔다.
 * 그리고 compute로 백트래킹 계산을 하면 된다.
 * 일단 index라는 걸 인자로 받아서 digits의 길이와 비교를 한다.
 * 같다면 result에 넣어둔다.
 * digit는 digits를 인덱스에 맞는 숫자로 변환시킨다.
 * 그리고 그 숫자에 맞는 문자배열을 map에서 가지고 온다.
 * 문자배열만큼 백트래킹을 통해 한개씩 조합해준다.
 * sb에 넣고, compute로 다시 돌리고 백트래킹을 위해 맨 뒤에 있는 숫자를 제거해준다.
 * 이후 result를 반환하면 된다.
 */