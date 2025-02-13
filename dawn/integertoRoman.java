/*
12. Integer to Roman

Seven different symbols represent Roman numerals with the following values:

Symbol	Value
I	1
V	5
X	10
L	50
C	100
D	500
M	1000
Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting a decimal place value into a Roman numeral has the following rules:

If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input, append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol, for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10. You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the subtractive form.
Given an integer, convert it to a Roman numeral.



Example 1:
Input: num = 3749
Output: "MMMDCCXLIX"
Explanation:
3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
 700 = DCC as 500 (D) + 100 (C) + 100 (C)
  40 = XL as 10 (X) less of 50 (L)
   9 = IX as 1 (I) less of 10 (X)
Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places

Example 2:
Input: num = 58
Output: "LVIII"
Explanation:
50 = L
 8 = VIII

Example 3:
Input: num = 1994
Output: "MCMXCIV"
Explanation:
1000 = M
 900 = CM
  90 = XC
   4 = IV
 */

class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> romanMap = new LinkedHashMap();
        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");

        StringBuilder sb = new StringBuilder();

        for (int key: romanMap.keySet()) {
            while(num>=key){
                sb.append(romanMap.get(key));
                num -= key;
            }
        }
        return sb.toString();
    }
}

/***
 * 이것도 저번이랑 비슷한 문제다. 이번엔 입력이 숫자로 들어오면 그걸 문자로 변환해서 return하면 되는것이다.
 * 근데 미리  for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).이렇게 적혀 있다.
 *
 * 내 입장에선 저걸 적어줘서 너무 편해졌다. 저번처럼 map을 이용해서 풀거고, string을 계속 붙여서 결과를 return해야하니까 StringBuilder를 이용해준다.
 * 여기서 유의할건 1000의 자리부터 큰수부터 순차적으로 돌아야한다는것이다. 그래서 map을 선언할때 Map<Integer, String> romanMap = new LinkedHashMap(); 이렇게 LinkedHashMap을 이용하게 되었다.
 * 그리고 map key 값을 바로 가져오기 위해서 map.keySet()을 이용했다. 입력받은 num이 key보다 크면 계속 돌린다.
 * 해당 숫자를 다 찾으면 stringBuilder에 붙여서 .toString()으로 return하면 된다.
 */