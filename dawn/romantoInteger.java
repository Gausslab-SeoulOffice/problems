/*
13. Roman to Integer

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.



Example 1:
Input: s = "III"
Output: 3
Explanation: III = 3.

Example 2:
Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 3:
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> symbolMap = new HashMap();
        int answer = 0;
        symbolMap.put('I', 1);
        symbolMap.put('V', 5);
        symbolMap.put('X', 10);
        symbolMap.put('L', 50);
        symbolMap.put('C', 100);
        symbolMap.put('D', 500);
        symbolMap.put('M', 1000);

        for (int i = 0; i < s.length() - 1; i++) {
            if (symbolMap.get(s.charAt(i)) < symbolMap.get(s.charAt(i + 1))) {
                answer -= symbolMap.get(s.charAt(i));
            } else {
                answer += symbolMap.get(s.charAt(i));
            }
        }
        return answer + symbolMap.get(s.charAt(s.length() - 1));
    }
}

/***
 * 쉬운문제라고 생각해서 너무 대충 읽었더니 한 번 틀렸다..ㅎ
 * symbol에 맞는 숫자들이 있고, 그 숫자를 더하면 되는데, 내 오른쪽에 있는 숫자가 나보다 크면 나는 -가 되는 것이다. 그렇게 최종 숫자를 return하면 되는 문제이다.
 *
 * 생각나는 방법은 일단 문자와 숫자니까 map에 입력해놓고, 그거 get해서 가지고 온 다음에 비교하고 answer에 넣으면 된다.
 * Map을 한개 선언해서 put으로 값들을 입력한다.
 * 그리고 입력된 s의 길이만큼 반복해줄건데, string에 있는거 한개씩 읽어오는 charAt를 사용하고 map의 get을 사용해서 value를 가지고 온다.
 * 그리고 오른쪽에 있는 것과 비교해서 현재값이 작으면 -를 하고 그게 아니라면 +를 하면 된다. i+1이 있기 때문에 마지막에 맨 끝에 있는 값을 더해주어야 한다.
 */