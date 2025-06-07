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
 * 이 문제는 숫자를 눌렀을때 나올 수 있는 문자열 조합을 모두 구하라는 문제이다.
 *
 * 재귀로 계속 구해야한다.
 * 일단 숫자에 맞는 문자들을 각각 저장해놔야하기때문에 map을 사용해서 각 문자들을 저장해 놓는다.
 * 그리고 함수를 호출하기 전에 입력받는 숫자가 없으면 그냥 빈 result를 반환하면 된다.
 * 이후 함수를 호출한다.
 * 이 함수는 문자열을 계속 더해주는 함수이다.
 * 일단 인덱스를 함께 넣어줘야한다.
 * 맨 처음에는 인덱스 0부터 시작하게 된다.
 * 만약에 인덱스가 길이와 같아진다면 다 돌았다는 의미이기에 result에 이제까지 만들어진 sb를 넣어주면된다.
 * 입력받은 번호가 string으로 들어오기때문에 한자리한자리 확인부터 해야한다.
 * 한자리를 때서 - '0'을 해주면 character로 형이 변환된다.
 * 이걸 가지고 map에 가서 맞는 문자들을 가지고 온다.
 * 문자들을 돌리면서 일단 sb에 넣고, 이후에 또 이어질 수 있는 문자들을 함께 입력해줘야하기때문에 함수를 다시 호출해야한다.
 * 함수를 호출할때는 다음 숫자에 대한 문자가 들어와야하기때문에 인덱스를 +1해줘야한다.
 * 그리고 한번 재귀를 한 다음에는 원래 상태로 돌려놔야 그 상태에서 또 새로운 문자열을 추가해서 만들 수 있기 때문에 sb에서 마지막 글자를 삭제해줘야한다.
 */