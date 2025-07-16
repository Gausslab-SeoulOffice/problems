/*
131. Palindrome Partitioning

Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.


Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:
Input: s = "a"
Output: [["a"]]
 */

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        compute(s, result, list, 0);
        return result;
    }

    private void compute(String s, List<List<String>> result, List<String> list, int index) {
        if (index == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                list.add(s.substring(index, i + 1));
                compute(s, result, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}

/***
 * 이 문제는 substring으로 palindrome을 만들 수 있는 경우의 수를 다 찾는 문제이다.
 *
 * 함수는 총 3개가 필요하다.
 * 하나는 백트래킹으로 단어를 만드는 compute 함수, 한개는 palindrome인지 확인하는 함수이다.
 * 일단 맨 처음에는 인덱스가 0으로 시작해서 compute함수에 넘긴다.
 * 여기서는 list에 들어가 있는 길이가 s랑 같으면 result에 넣게되고 마지막 단어이기 때문에 return을 한다.
 * 그게 아니라면 계산해서 list에 들어갈 단어를 찾는 과정을 거친다.
 * 들어온 인덱스부터 i까지의 수를 잘라서 palindrome함수에 넘겨서 이 단어들이 palindrome인지 확인한다.
 * 맞다면 그 단어는 list에 추가되게 된다.
 * 그리고 단어의 모든 조합을 찾으려면 백트래킹으로 compute함수를 돌려야하기 때문에 list에 있는 마지막 인자를 제거하면 된다.
 * 이후 result를 반환하면 된다.
 */