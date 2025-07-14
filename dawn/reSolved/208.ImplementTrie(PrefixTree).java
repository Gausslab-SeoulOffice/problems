/*
208. Implement Trie (Prefix Tree)

A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.


Example 1:
Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]
Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
 */

class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

/***
 * 이 문제는 trie를 구현하는 문제이다.
 *
 * children: 알파벳 소문자 26개에 대한 자식 노드 저장, isEnd: 이 노드가 단어의 끝인지 여부 (true면 완전한 단어)이다.
 * Trie함수 같은 경우 'a' ~ 'z' 각각에 해당하는 자식을 저장할 배열 children 생성하고 기본 생성자에서 isEnd = false로 초기화한다.
 * insert경우 단어를 한 글자씩 따라가며, 없으면 새로운 TrieNode를 만들어 준다.
 * 마지막 글자 노드에 isEnd = true를 설정하여 단어의 끝 표시한다.
 * search경우 단어의 모든 글자를 트라이에서 따라간다.
 * 마지막 노드에 도달했을 때 isEnd == true이면 해당 단어가 존재한다.
 * 예:"apple"을 넣었으면 "apple" → true, "app" → false
 * startsWith경우 prefix를 구성하는 글자만 따라가면 되며, isEnd는 확인하지 않는다.
 * 해당 prefix로 시작하는 단어가 있으면 true이다.
 */