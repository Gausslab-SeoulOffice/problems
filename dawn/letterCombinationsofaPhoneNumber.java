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

        if(digits.length() == 0){
            return result;
        }
        compute(digits, 0, sb, result, map);
        return result;
    }

    private void compute(String digits, int index, StringBuilder sb, List<String> result, Map<Integer, List<Character>> map){
        if(index == digits.length()){
            result.add(sb.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        List<Character> letters = map.get(digit);

        for(char ch : letters){
            sb.append(ch);
            compute(digits, index+1, sb, result, map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

/***
 * 이 문제는 조합할 수 있는 모든 문자열을 조합해서 반환하라는 문제이다.
 *
 * 일단 숫자에 지정된 문자들이 각각 있으니까 map으로 묶어준다.
 * 그리고 digits가 없으면 그냥 빈리스트를 반환하고, 있으면 한개씩 확인해준다.
 * 그 확인하는 함수가 compute이다.
 * 지금 index가 마지막 이라면 result에 추가한다.
 * 그게 아니면 이제 한개씩 확인해서 만들어야한다.
 * 일단 digits에서 해당 인덱스에 맞는 문자를 가지고와서 숫자로 바꿔준다,
 * 그리고 map에서 숫자에 맞는 값을 가지고 온다.
 * 이제 한개씩 sb에 붙이면 된다.
 * 리스트에 있는 문자 한개를 일단 sb에 붙이고 그 다음에 조합할 수 있는 문자를 찾아야하기에 다시 compute를 한다.
 * 그 대신 index는 다음으로 넘어가게 된다.
 * 그리고 sb는 찾은다음에는 붙인 문자를 지워야 그 자리에 다시 붙일 수 있기 때문에 deleteCharAt을 해준다.
 */