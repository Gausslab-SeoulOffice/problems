/*
383. Ransom Note

Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote.


Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:
Input: ransomNote = "aa", magazine = "aab"
Output: true

 */

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c : magazine.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(char c: ransomNote.toCharArray()){
            if(!map.containsKey(c) ||map.get(c)<=0){
                return false;
            }
            map.put(c, map.get(c)-1);
        }
        return true;
    }
}

/***
 * 이 문제는 입력을 두개의 string을 받는데, magazine에 있는게 사용할 수 있는 자제고 만들고 싶은건 ransomNote라고 생각하면 된다. 가능한지 묻는거다.
 *
 * 자제만큼 있냐고 묻는거기 때문에 HashMap으로 갯수를 세면 되는 일이다.
 * 일단 HashMap을 선언해서 magazine에 있는 단어들의 갯수를 입력해준다.
 * 그리고 ransomNote에 있는 단어들을 한개씩 가지고 와서 확인하면된다.
 * 단어가 map에 없거나, 갯수가 0 보다 작거나같으면 false를하고, 그게 아니라면 있다는 소리니까 -1을 해서 넣어주면 된다.
 */