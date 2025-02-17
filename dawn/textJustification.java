/*
68. Text Justification

Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified, and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.

Example 1:
Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

Example 2:
Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
Note that the second line is also left-justified because it contains only one word.

Example 3:
Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
 */

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> currWords = new ArrayList<>();
        int currLen = 0;

        for (String word : words) {
            if (currLen + word.length() + currWords.size() > maxWidth) {
                int totalSpaces = maxWidth - currLen;
                int gaps = currWords.size() - 1;
                if (gaps == 0) {
                    result.add(currWords.get(0) + " ".repeat(totalSpaces));
                } else {
                    int spacePerGap = totalSpaces / gaps;
                    int extraSpaces = totalSpaces % gaps;
                    StringBuilder line = new StringBuilder();
                    for (int i = 0; i < currWords.size(); i++) {
                        line.append(currWords.get(i));
                        if (i < gaps) {
                            line.append(" ".repeat(spacePerGap));
                            if (i < extraSpaces) {
                                line.append(' ');
                            }
                        }
                    }
                    result.add(line.toString());
                }
                currWords.clear();
                currLen = 0;
            }
            currWords.add(word);
            currLen += word.length();
        }

        StringBuilder lastLine = new StringBuilder(String.join(" ", currWords));
        while (lastLine.length() < maxWidth) {
            lastLine.append(" ");
        }
        result.add(lastLine.toString());
        return result;
    }
}

/***
 * 이 문제는 결국 못풀었다.
 * 이해는 문제가 없다. 단어리스트인 words가 주어지고 가장 긴 길이인 maxWidth가 주어진다.
 * 그럼 한 줄 안에 maxWidth만큼 단어를 넣고, 공백으로 띄우기를 하면되는데, 그 공백은 동일하게 띄워져야한다.
 *
 * List<String> result = new ArrayList<>();
 * List<String> currWords = new ArrayList<>();
 * int currLen = 0;
 * 이부분은 result는 최종적으로 정렬된 문장을 저장할 리스트이다.
 * currWords는 현재 줄에 포함될 단어들을 저장할 리스트이다.
 * currLen은 현재 줄의 단어들의 총 문자 길이이다.
 *
 * int totalSpaces = maxWidth - currLen;
 * int gaps = currWords.size() - 1;
 * totalSpaces는 공백의 총 개수를 의미한다.
 * gaps는 단어 사이의 공백의 수이다.
 *
 * if (gaps == 0) {
 *     result.add(currWords.get(0) + " ".repeat(totalSpaces));
 * }
 *  이건 gaps== 0이므로 단어가 하나뿐일때를 의미한다.
 * 단어가 한개뿐이면 단어 뒤에 공백을 추가해서 maxWidth를 맞춰야한다.
 *
 * int spacePerGap = totalSpaces / gaps;
 * int extraSpaces = totalSpaces % gaps;
 * StringBuilder line = new StringBuilder();
 *  spacePerGap은 각 공백 간격에 들어갈 기본 공백 개수이고,
 * extraSpaces는 공백을 골고루 분배했을때 일부 간격에 더 추가해야하는 공백 개수이다.
 *
 * for (int i = 0; i < currWords.size(); i++) {
 *     line.append(currWords.get(i));
 *     if (i < gaps) {
 *         line.append(" ".repeat(spacePerGap));
 *         if (i < extraSpaces) {
 *             line.append(' ');
 *         }
 *     }
 * }
 *  currWords 리스트에서 단어를 한개씩 가져와서, i < gaps 마지막 단어가 아닐 경우 공백을 추가한다.
 * 그리고 기본 공백을 추가하고, extraSpaces만큼 앞쪽부터 한칸씩 더 추가한다.
 *
 * StringBuilder lastLine = new StringBuilder(String.join(" ", currWords));
 * while (lastLine.length() < maxWidth) {
 *     lastLine.append(" ");
 * }
 * result.add(lastLine.toString());
 *  이건 좌측정렬이다.
 * String.join(" ", currWords)는 단어들을 공백 한 칸으로 이어 붙인다.
 * 그리고 남을 공백을 모두 추가한다.
 */