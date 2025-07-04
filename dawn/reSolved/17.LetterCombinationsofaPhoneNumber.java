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
        compute(digits, result, sb, map, 0);
        return result;
    }

    private void compute(String digits, List<String> result, StringBuilder sb, Map<Integer, List<Character>> map,
                         int index) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        List<Character> letters = map.get(digit);

        for (char ch : letters) {
            sb.append(ch);
            compute(digits, result, sb, map, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}

/***
 * 이 문제는 숫자를 눌렀을때 조합될 수 있는 모든 문자열을 반환하라는 문제이다,
 *
 * 일단 map에 지정해서 넣어둔다.
 * 그리고 compute라는 함수를 지정해서 백트래킹을 해야한다.
 * 일단 숫자가 String으로 들어오기때문에 한글자씩 int로 변경한다.
 * 그리고 그 단어에 대응되는 문자를 map에서 가지고 온다.
 * 그리고 sb에 넣는다. 이후 조합될 수 있는 문자열을 가지고 와야한다.
 * 그 다음으로 넘어가기전에 마지막 단어는 삭제해주어야한다.
 */