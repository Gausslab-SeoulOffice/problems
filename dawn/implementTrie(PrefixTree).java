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
 * 이 문제는 각 명령어에 맞게 함수를 완성하라는 문제이다.
 *
 * 일단 TrieNode객체를 한 개 만들어준다.
 * 여기에는 26 개의 영어 소문자(a‒z)에 대한 다음 노드 포인터 배열을 담을 children[26]이 있을거고, 단어의 마지막 단어를 의미하는 isEnd라는 변수가 있다.
 * a(0) ─ p(15) ─ p(15) ─ l(11) ─ e(4)   ← "apple" 이런식이 될 예정이다.
 * insert(String word)의 경우 node = root 부터 시작, 단어의 각 문자 c를 순회하며 index = c - 'a' 계산, 자식 노드가 비어 있으면 new TrieNode() 생성, node = node.children[index] 로 이동, 마지막 문자 처리 후 isWord = true 로 단어 종료 표시한다.
 * search(String word)의 경우 root부터 문자마다 인덱스 계산해 내려감, 중간에 children[index] == null이면 단어 없음 → false, 끝까지 도달했을 때 node.isEnd 가 true 면 찾는것이다.
 * 단어 전체 일치가 필요하므로 마지막 노드의 isEnd 확인이 중요하다.
 * startsWith(String prefix)의 경우 root부터 prefix의 문자대로 노드를 내려감, 중간에 null을 만나면 해당 접두사로 시작하는 단어 없음 → false, 끝까지 내려가면 무조건 true (단어 완성 여부는 보지 않음)
 */