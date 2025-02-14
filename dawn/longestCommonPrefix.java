/*
14. Longest Common Prefix

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);
        String firstWord = strs[0];
        String lastWord = strs[strs.length-1];
        int index = 0;
        while (index < firstWord.length()) {
            if(firstWord.charAt(index) == lastWord.charAt(index)){
                index++;
            }else{
                break;
            }
        }
        for (int i = 0; i < index; i++) {
            sb.append(firstWord.charAt(i));
        }
        return sb.toString();
    }
}

/***
 * 너무 복잡하게 생각했더니 시간이 좀 걸린 문제이다.
 * 단어들의 배열이 주어지면 앞에 붙은 prefix가 뭔지 찾는 문제였다.
 *
 * 일단 단어들을 계속 붙여서 return해야한다는 생각에 StringBuilder를 한 개 선언해준다.
 * 그리고 이 단어를 정렬하면 맨 앞이랑, 맨 뒤랑 비교하면 된다는 이 아이디어를 찾아내는데 시간이 좀 걸렸다.
 * 그리고 first단어 인덱스를 이용해서 찾아낼거고, 인덱스에 있는 character가 같으면 index ++하고 다르면 더 이상 찾을 필요가 없기에 break한다. 그리고 인덱스만큼 stringBuilder에 넣어서 return하면 된다.
 */